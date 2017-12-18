package sdc;

import Value.Value;

public class Variable {

	private String nomVar;
	private Value value;

	public Variable(String nomVar, Value value) {
		this.nomVar = "$" + nomVar;
		this.value = value;
	}

	public Variable() {
	}

	public String toString() {
		return value.toString();
	}

	public boolean compareValue(Value current) {
		return this.value.equals(current);
	}
	
	public boolean compareName(String current) {
		return this.nomVar.substring(1,this.nomVar.length()).toLowerCase().equals(current.toLowerCase());
	}
	
	public boolean compareNameSet(String current) {
		return this.nomVar.toLowerCase().equals(current.toLowerCase());
	}
	
	public Value giveValue() {
		return this.value; 
	}
}
