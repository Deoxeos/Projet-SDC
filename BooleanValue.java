package sdc;

public class BooleanValue extends Value {

	private boolean value;
	
	public BooleanValue() {
		this.value = false;
	}

	public BooleanValue(boolean b) {
		this.value = b;
	}

	public BooleanValue etLogique(BooleanValue bv) throws IncompatibleTypeException {
		return new BooleanValue(this.value && bv.value);
	}

	public BooleanValue ouLogique(BooleanValue bv) throws IncompatibleTypeException {
		return new BooleanValue(this.value || bv.value);
	}

	public BooleanValue negLogique() throws IncompatibleTypeException {
		return new BooleanValue(!this.value);
	}
	
	public String toString() {
		return this.value + "";
	}
	public boolean parse(String s) {

		try {
			this.value = Boolean.parseBoolean(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
