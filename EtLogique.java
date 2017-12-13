package sdc;

public class EtLogique extends BinaryOperation {

	@Override
	public boolean parse(String s) {
		return s.equals("&"); 
	}

	@Override
	public BooleanValue compute(Value v1, Value v2) throws IncompatibleTypeException {
		BooleanValue nv1;
		BooleanValue nv2;

		try {
			nv1 = (BooleanValue) v1;
			nv2 = (BooleanValue) v2;
		} catch (Exception e) {
			throw new IncompatibleTypeException();
		}
		return nv1.etLogique(nv2);

	}
}
