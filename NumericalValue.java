package sdc;

public abstract class NumericalValue extends Value {

	public abstract NumericalValue multiply(NumericalValue v) throws IncompatibleTypeException;

	public abstract NumericalValue divide(NumericalValue v) throws IncompatibleTypeException;

	public abstract NumericalValue add(NumericalValue v) throws IncompatibleTypeException;

	public abstract NumericalValue substract(NumericalValue v) throws IncompatibleTypeException;

	public abstract NumericalValue abs();
	
	public abstract boolean parse(String s); 

}
