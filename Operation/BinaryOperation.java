package Operation;

import java.util.Stack;

import Exception.IncompatibleTypeException;
import Symbol.Symbol;
import Value.Value;

public abstract class BinaryOperation implements Symbol {

	public abstract Value compute(Value v1, Value v2) throws IncompatibleTypeException;
	
	
	public void execute(Stack<Value> s) throws IncompatibleTypeException {
		Value v1 = s.pop();
		Value v2 = s.pop();

		s.push(this.compute(v1, v2));
	}

}
