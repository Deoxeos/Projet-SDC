package Symbol;

import java.util.Stack;

import Exception.IncompatibleTypeException;
import Exception.ShutdownException;
import Value.Value;
import sdc.SDC;

public class ElseSymbol implements Symbol {

	@Override
	public boolean parse(String s) {
		return s.toLowerCase().equals("else");
	}

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException {
		SDC.elseTraitement();
		
	}

}
