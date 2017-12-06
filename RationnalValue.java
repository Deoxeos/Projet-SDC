package sdc;

public class RationnalValue extends Value {

	private int numerateur;
	private int denominateur;

	public String toString() {
		return this.numerateur + "#" + this.denominateur; 
	}
	
	@Override
	public boolean parse(String s) {

		try {
			this.numerateur = Integer.parseInt(s.split("#")[0]);
			this.denominateur = Integer.parseInt(s.split("#")[1]);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;

	}

	public RationnalValue(int numerateur, int denominateur) {
		this.numerateur = numerateur;

		if (denominateur == 0) {
			throw new IllegalArgumentException();
		}

		this.denominateur = denominateur;
	}

	@Override
	public Value divide(Value v) throws IncompatibleTypeException {
		if (!(v instanceof RationnalValue)) {
			throw new IncompatibleTypeException();
		}

		RationnalValue value = new RationnalValue(((RationnalValue) v).denominateur, ((RationnalValue) v).numerateur);

		int resNumerateur = (value.numerateur * this.numerateur);
		int resDenominateur = (value.denominateur * this.denominateur);
		int pgcd = pgcd(resNumerateur, resDenominateur);

		return new RationnalValue(resNumerateur / pgcd, resDenominateur / pgcd);

	}

	@Override
	public Value add(Value v) throws IncompatibleTypeException {

		if (!(v instanceof RationnalValue)) {
			throw new IncompatibleTypeException();
		}

		RationnalValue value = new RationnalValue(((RationnalValue) v).numerateur, ((RationnalValue) v).denominateur);

		int resNumerateur = ((value.denominateur * this.numerateur) + (this.denominateur * value.numerateur));
		int resDenominateur = (this.denominateur * value.denominateur);
		int pgcd = pgcd(resNumerateur, resDenominateur);

		return new RationnalValue(resNumerateur / pgcd, resDenominateur / pgcd);
	}

	@Override
	public Value substract(Value v) throws IncompatibleTypeException {
		if (!(v instanceof RationnalValue)) {
			throw new IncompatibleTypeException();
		}

		RationnalValue value = new RationnalValue(((RationnalValue) v).numerateur, ((RationnalValue) v).denominateur);

		int resNumerateur = ((value.denominateur * this.numerateur) - (this.denominateur * value.numerateur));
		int resDenominateur = (this.denominateur * value.denominateur);
		int pgcd = pgcd(resNumerateur, resDenominateur);

		return new RationnalValue(resNumerateur / pgcd, resDenominateur / pgcd);

	}

	@Override
	public Value abs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value multiply(Value v) throws IncompatibleTypeException {
		if (!(v instanceof RationnalValue)) {
			throw new IncompatibleTypeException();
		}

		RationnalValue value = new RationnalValue(((RationnalValue) v).numerateur, ((RationnalValue) v).denominateur);

		int resNumerateur = (value.numerateur * this.numerateur);
		int resDenominateur = (value.denominateur * this.denominateur);
		int pgcd = pgcd(resNumerateur, resDenominateur);

		return new RationnalValue(resNumerateur / pgcd, resDenominateur / pgcd);
	}

	public static int pgcd(int a, int b) {
		int r;
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public RationnalValue() {
		this.numerateur= 0; 
		this.denominateur = 1;
	}

}
