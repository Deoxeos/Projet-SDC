package sdc;

import Value.Value;

public class Variable {

	private String nomVar;
	private Value value;

	public Variable(String nomVar, Value value) {
		this.nomVar = "$" + nomVar;
		this.value = value;
	}
	
	public Variable updateVar(Value v) {
		return new Variable(this.nomVar.substring(1,this.nomVar.length()),v); 
	}

	public Variable() {
	}

	public String toString() {
		return this.nomVar + " contient " + value.toString();
	}

	public boolean compareValue(Value current) {
		return this.value.equals(current);
	}
	
	public boolean compareName(String current) {
		
		if(!current.startsWith("$")) {
			current = "$" + current; 
		}
		
		return this.nomVar.toLowerCase().equals(current.toLowerCase());
	}

	public String chargeToken() {
		return this.value.toString();
	}
}
