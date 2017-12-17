package sdc;

import java.util.StringTokenizer;
import java.util.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;

public class SDC {

	private Factory factory;
	private Stack<Value> stack;
	private ArrayList<Variable> variables;

	public SDC() {
		this.factory = new Factory();
		this.stack = new Stack<Value>();
		this.variables = new ArrayList<Variable>();
	}

	public void executeLine(String line) throws ShutdownException, InternalError, IncompatibleTypeException,
			StackException, SymbolNotFoundException, VariableException {
		// main method:

		// parse the line to execute
		// tokens are separated by a space

		System.out.println(line);

		if (line.startsWith("$")) {
			int idVar = getId(line);
			line = this.variables.get(idVar).toString();
		}

		StringTokenizer st = new StringTokenizer(line);

		if (line.equals("viewv")) {
			viewv();
		}

		if (line.equals("view")) {
			view();
		} else {

			while (st.hasMoreTokens()) {

				// read the next token
				String token = st.nextToken();

				// try every registered symbole
				boolean found = false;
				for (Symbol s : this.factory.registered()) {

					if (s.parse(token)) {
						found = true;
						@SuppressWarnings("unchecked")
						Stack<Value> oldStack = (Stack<Value>) stack.clone();
						try {
							s.execute(this.stack);
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

				if (!found) {
					boolean addVar = true;
					AffectValue testor = new AffectValue("=>");
					Value current;
					Value currentBefore;
					if (!stack.isEmpty()) {
						current = stack.pop();
						currentBefore = stack.pop();

						if (current.toString().equals("=>")) {
							addVar = !isAlreadyIn(token);
							if (addVar)
								variables.add(new Variable(token, currentBefore));
						} else {
							System.out.println(current.equals(testor));
							throw new SymbolNotFoundException("the token " + token + " has not been recognized. Abort");
						}
						if (!addVar) {
							throw new VariableException("Erreur lors de l'ajout de la variable " + token);
						}
					}

				}

			}

		}

	}

	private int getId(String line) {
		int id = 0;

		for (int i = 0; i < variables.size(); i++) {
			if (variables.get(i).compareNameSet(line))
				id = i;
		}

		return id;
	}

	public void view() {

		for (int i = 0; i < stack.size(); i++) {
			System.out.println(((stack.size() - i) + " ----> " + stack.get(i)));
		}

	}

	public void viewv() {
		for (Variable current : this.variables) {
			System.out.println(current);
		}
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

		for (Variable v : this.variables) {
			if (v.compareName(search)) {
				return true;
			}
		}

		return false;
	}

}
