package sdc;

public class Variable {

	private String nomVar;
	private Value value;

	public Variable(String nomVar, Value value) {
		this.nomVar =  "$" + nomVar;
		this.value = value;
	}


}
