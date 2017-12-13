package sdc;

import java.util.Stack;

public class IntegerValue extends NumericalValue {

	private int value;

	public IntegerValue() {
		this(0);
	}

	public IntegerValue(int value) {
		this.value = value;
	}

	public boolean parse(String s) {
		try {
			this.value = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "" + this.value;
	}

	public NumericalValue add(NumericalValue v) throws IncompatibleTypeException {

		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value + this.value);
	}

	public NumericalValue multiply(NumericalValue v) throws IncompatibleTypeException {

		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value * this.value);
	}

	public NumericalValue divide(NumericalValue v) throws IncompatibleTypeException {

		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value / this.value);
	}

	public NumericalValue substract(NumericalValue v) throws IncompatibleTypeException {

		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value - this.value);
	}

	public NumericalValue abs() {
		// attention à bien créer une nouvelle instance
		if (this.value < 0) {
			return new IntegerValue(-1 * this.value);
		} else {
			return new IntegerValue(this.value);
		}
	}

	

}
