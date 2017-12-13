package sdc;

public class MulOperation extends BinaryOperation {

	public boolean parse(String s) {
		return s.equals("*");
	}

	

	public NumericalValue compute(NumericalValue v1, NumericalValue v2) throws IncompatibleTypeException {
		return v1.multiply(v2);
	}



	@Override
	public NumericalValue compute(Value v1, Value v2) throws IncompatibleTypeException {
		// TODO Auto-generated method stub
		return null;
	}

}
