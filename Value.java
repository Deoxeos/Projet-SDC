package Value;

import java.util.Stack;

import Symbol.Symbol;

public abstract class Value implements Symbol{

	
	public abstract boolean parse(String s); 
	
	
	public void execute(Stack<Value> s) {
		s.push(this); 
	}
}
