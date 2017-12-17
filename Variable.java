package sdc;

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

	public boolean compareName(String current) {
		return this.nomVar.equals("$" + current);
	}
	
	public boolean compareNameSet(String current) {
		return this.nomVar.equals(current);
	}
	
	public Value giveValue() {
		return this.value; 
	}

}
