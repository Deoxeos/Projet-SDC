package Symbol;

import java.util.Stack;

import Exception.IncompatibleTypeException;
import Exception.ShutdownException;
import Value.Value;

public class ClearSymbol implements Symbol {

	public boolean parse(String s) {
		return s.equals("clear");
	}

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException {
		s.clear(); 		
	}

	

}