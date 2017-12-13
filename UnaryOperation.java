package sdc;

import java.util.Stack;

public abstract class UnaryOperation implements Symbol {

	public abstract Value compute(Value v1) throws IncompatibleTypeException;

	public void execute(Stack<Value> s) throws IncompatibleTypeException {
		Value v1 = s.pop();
		
		s.push(this.compute(v1));
	}
}
