package sdc;

import java.util.Stack;

public abstract class Value implements Symbol{

	
	public abstract boolean parse(String s); 
	
	
	public void execute(Stack<Value> s) {
		s.push(this); 
	}
}
