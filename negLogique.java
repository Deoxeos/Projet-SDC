package sdc;

public class negLogique extends UnaryOperation {

	@Override
	public boolean parse(String s) {
		return s.equals("~");
	}

	@Override
	public BooleanValue compute(Value v1) throws IncompatibleTypeException {
		BooleanValue nv1;

		try {
			nv1 = (BooleanValue) v1;
		} catch (Exception e) {
			throw new IncompatibleTypeException();
		}
		return nv1.negLogique();
	}

}
