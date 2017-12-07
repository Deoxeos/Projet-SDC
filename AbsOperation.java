package sdc;

public class AbsOperation extends UnaryOperation {

	@Override
	public boolean parse(String s) {
		return s.equals("||");
	}

	@Override
	public Value compute(Value v1) throws IncompatibleTypeException {
		
		return v1.abs(); 
	}

}
