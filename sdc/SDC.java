package sdc;

import java.util.StringTokenizer;
import Exception.IncompatibleTypeException;
import Exception.InternalError;
import Exception.ShutdownException;
import Exception.StackException;
import Exception.SymbolNotFoundException;
import Exception.VariableException;
import Symbol.Symbol;
import Value.Value;
import java.util.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class SDC {

	private Factory factory;
	private Stack<Value> stack;
	private static ArrayList<Variable> variables;
	private String previousToken;
	private static String waitedSymbol;
	private static boolean canExecute;

	public SDC() {
		this.factory = new Factory();
		this.stack = new Stack<Value>();
		variables = new ArrayList<Variable>();
		this.previousToken = "";

		canExecute = true;
	}

	public void executeLine(String line) throws ShutdownException, InternalError, IncompatibleTypeException,
			StackException, SymbolNotFoundException, VariableException {
		// main method:

		// parse the line to execute
		// tokens are separated by a space

		StringTokenizer st = new StringTokenizer(line);

		while (st.hasMoreTokens()) {

			// read the next token
			String token = st.nextToken();

			// try every registered symbole
			boolean found = false;
			for (Symbol s : this.factory.registered()) {

				if (s.parse(introduceVariable(token))) {
					found = true;

					@SuppressWarnings("unchecked")
					Stack<Value> oldStack = (Stack<Value>) stack.clone();
					try {
						if (token.toLowerCase().equals(waitedSymbol)) {
							canExecute = true;
						}

						if (canExecute) {
							s.execute(this.stack);
						}

					} catch (EmptyStackException e) {
						// we might have read some symbols from the stack
						// roll back
						this.stack = oldStack;
						throw new StackException("Empty stack --- aborting last operations");
					} catch (IncompatibleTypeException e) {
						// we might have read some symbols from the stack
						// roll back
						this.stack = oldStack;
						throw new IncompatibleTypeException(
								"Illegal operations: values must have the same type --- aborting last operations");
					}
					break;
				}
				// continue to the next symbol
			}

			if (canExecute && !found) {

				if (this.previousToken.equals("=>")) {
					createVariable(token);
				} else {
					canExecute = true;
					throw new SymbolNotFoundException("the token " + token + " has not been recognized. Abort");
				}

			}

			this.previousToken = token;
		}

	}

	public void createVariable(String token) throws VariableException, SymbolNotFoundException {
		boolean isIn = true;
		Value current;
		Value valueAdd;
		if (!stack.isEmpty() && stack.size() > 1) {
			current = stack.pop();
			valueAdd = stack.pop();

			if (current.toString().equals("=>")) {
				isIn = isAlreadyIn(token);
			}

			if (!isIn) {
				variables.add(new Variable(token, valueAdd));
			}

			if (isIn) {
				int id = getId("$" + token);
				Variable newVar = variables.get(id).updateVar(valueAdd);
				variables.remove(id);
				variables.add(newVar);
			}
		}
	}

	public String introduceVariable(String token) throws VariableException {
		if (canExecute && token.startsWith("$")) {

			Integer id = getId(token);

			if (id == -1) {
				throw new VariableException("Illegal operation: unknown variable. Ignore last command line");
			}

			token = variables.get(id).chargeToken();
		}

		return token;
	}

	private int getId(String line) {
		int id = -1;

		for (int i = 0; i < variables.size(); i++) {
			if (variables.get(i).compareName(line))
				id = i;
		}

		return id;
	}

	public String getLastResult() {
		try {
			Value v = this.stack.peek();
			return v.toString();
		} catch (EmptyStackException e) {
			return "";
		}
	}

	public boolean isAlreadyIn(String search) {

		for (Variable v : variables) {
			if (v.compareName(search)) {
				return true;
			}
		}

		return false;
	}

	public static void ifTraitementFalse(String string) {
		waitedSymbol = "else";
		canExecute = false;
	}

	public static void ifTraitementTrue() {
		waitedSymbol = "endif";
		canExecute = true;
	}

	public static void noOperation() {
		waitedSymbol = "endif";
		canExecute = false;
	}

	public static void elseTraitement() {
		if (waitedSymbol.equals("endif")) {
			canExecute = false;
		}

		if (waitedSymbol.equals("else")) {
			canExecute = true;
			waitedSymbol = "endif";
		}
	}

	public static void viewVar() {
		for (Variable current : variables) {
			System.out.println(current.toString());
		}
	}

}
