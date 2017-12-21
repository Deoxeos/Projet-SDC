package Symbol;

import java.util.Stack;

import Exception.IncompatibleTypeException;
import Exception.ShutdownException;
import Value.BooleanValue;
import Value.Value;
import sdc.SDC;

public class IfSymbol implements Symbol {

	@Override
	public boolean parse(String s) {
		return s.toLowerCase().equals("if");
	}

	@Override
	public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException {
		BooleanValue bv;

		try {
			bv = (BooleanValue) s.pop();
			if (bv.isTrue()) {
				SDC.ifTraitementTrue(); 
			} else {
				SDC.ifTraitementFalse("else"); 
			}
		} catch (Exception e) {
			SDC.noOperation(); 
		}
	}

}
