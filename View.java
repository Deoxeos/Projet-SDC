package sdc;

import java.util.Stack;

public class View implements Symbol {

	@Override
	public boolean parse(String s) {
		return s.equals("view"); 
	}

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException {
		
		for (int i = 0; i < s.size(); i++) {
			System.out.println(((s.size() - i) + " ----> " + s.get(i)));
		}
	}

}
