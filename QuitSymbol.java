package sdc;

import java.util.Stack;

public class QuitSymbol implements Symbol {
    
    public boolean parse(String s) {
	return s.equals("quit");
    }

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException {
		throw new ShutdownException();		
	}
    
 

}