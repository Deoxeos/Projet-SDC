package sdc;

import java.util.Stack;

public class ClearSymbol implements Symbol {

	public boolean parse(String s) {
		return s.equals("clear");
	}

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException {
		s.clear(); 		
	}

	

}