package Symbol;

import java.util.Stack;

import Exception.IncompatibleTypeException;
import Exception.ShutdownException;
import Value.Value;

public class QuitSymbol implements Symbol {
    
    public boolean parse(String s) {
	return s.equals("quit");
    }

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException {
		throw new ShutdownException();		
	}
    
 

}