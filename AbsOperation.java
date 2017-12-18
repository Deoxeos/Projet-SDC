package Operation;

import Exception.IncompatibleTypeException;
import Value.NumericalValue;
import Value.Value;

public class AbsOperation extends UnaryOperation {

	@Override
	public boolean parse(String s) {
		return s.equals("||");
	}

	@Override
	public NumericalValue compute(Value v1) throws IncompatibleTypeException {
		NumericalValue nv1;

		try {
			nv1 = (NumericalValue) v1;

		} catch (Exception e) {
			throw new IncompatibleTypeException();
		}
		return nv1.abs();

	}
}
