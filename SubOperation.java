package Operation;

import Exception.IncompatibleTypeException;
import Value.NumericalValue;
import Value.Value;

public class SubOperation extends BinaryOperation {

	public boolean parse(String s) {
		return s.equals("-");
	}

	@Override
	public NumericalValue compute(Value v1, Value v2) throws IncompatibleTypeException {

		NumericalValue nv1;
		NumericalValue nv2;

		try {
			nv1 = (NumericalValue) v1;
			nv2 = (NumericalValue) v2;
		} catch (Exception e) {
			throw new IncompatibleTypeException();
		}
		return nv1.substract(nv2);

	}

}
