package Symbol;

import java.util.Stack;

import Exception.IncompatibleTypeException;
import Exception.ShutdownException;
import Value.Value;

public class ViewSymbol implements Symbol {

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
