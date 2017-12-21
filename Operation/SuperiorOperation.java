package Operation;

import Exception.IncompatibleTypeException;
import Value.NumericalValue;
import Value.Value;

public class SuperiorOperation extends BinaryOperation {

	@Override
	public boolean parse(String s) {
		return s.equals(">");
	}

	@Override
	public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
		NumericalValue nv1;
		NumericalValue nv2;

		try {
			nv1 = (NumericalValue) v1;
			nv2 = (NumericalValue) v2;
		} catch (Exception e) {
			throw new IncompatibleTypeException();
		}
		return nv1.superior(nv2);
	}
}
