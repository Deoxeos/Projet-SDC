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
	private ArrayList<Variable> variables;
	private String previousToken; 

	public SDC() {
		this.factory = new Factory();
		this.stack = new Stack<Value>();
		this.variables = new ArrayList<Variable>();
		this.previousToken = ""; 
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
			
				
				if(this.previousToken.equals("=>")){
					createVariable(token);
				} else {
					throw new SymbolNotFoundException("the token " + token + " has not been recognized. Abort"); 
				}
				
				
			}
			
		this.previousToken = token; 
		}

	}

	public void createVariable(String token) throws VariableException, SymbolNotFoundException {
		boolean addVar = true;
		Value current;
		Value valueAdd;
		if (!stack.isEmpty() && stack.size() > 1) {
			current = stack.pop();
			valueAdd = stack.pop();

			if (current.toString().equals("=>")) {
				addVar = !isAlreadyIn(token);
				
			}

			if (addVar) {
				variables.add(new Variable(token, valueAdd));
			}
			
			if (!addVar) {
				int id = getId("$" + token); 
				Variable newVar = this.variables.get(id).updateVar(valueAdd); 
				this.variables.remove(id); 
				this.variables.add(newVar); 
				addVar = true; 
			}
		}
	}

	public String introduceVariable(String token) throws VariableException {
		if (token.startsWith("$")) {

			Integer id = getId(token);

			if (id == -1) {
				throw new VariableException("Illegal operation: unknown variable. Ignore last command line");
			}
			
			token = this.variables.get(id).toString();
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

		for (Variable v : this.variables) {
			if (v.compareName(search)) {
				return true;
			}
		}

		return false;
	}

}
