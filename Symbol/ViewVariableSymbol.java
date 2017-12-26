package Symbol;

import java.util.Stack;

import Exception.IncompatibleTypeException;
import Exception.ShutdownException;
import Value.Value;
import sdc.SDC;

public class ViewVariableSymbol implements Symbol {

	@Override
	public boolean parse(String s) {
		return s.toLowerCase().equals("variables");
	}

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException {
		SDC.viewVar(); 
		
	}

}
