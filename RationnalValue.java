package Value;

import Exception.IncompatibleTypeException;

public class RationnalValue extends NumericalValue {

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
	public NumericalValue divide(NumericalValue v) throws IncompatibleTypeException {
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
	public NumericalValue add(NumericalValue v) throws IncompatibleTypeException {

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
	public NumericalValue substract(NumericalValue v) throws IncompatibleTypeException {
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
	public NumericalValue abs() {

		int absNume = 0;
		int absDeno = 1;

		if (this.numerateur < 0) {
			absNume = this.numerateur * -1;
		} else {
			absNume = this.numerateur;
		}

		if (this.denominateur < 0) {
			absDeno = this.denominateur * -1;
		} else {
			absDeno = this.denominateur;
		}

		return new RationnalValue(absNume, absDeno);

	}

	@Override
	public NumericalValue multiply(NumericalValue v) throws IncompatibleTypeException {
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
		this.numerateur = 0;
		this.denominateur = 1;
	}

	@Override
	public BooleanValue superior(NumericalValue v) throws IncompatibleTypeException {
		if (!(v instanceof NumericalValue)) {
			throw new IncompatibleTypeException();
		}		
		
		float v1 = (float)((RationnalValue) v).numerateur / (float)((RationnalValue) v).denominateur; 
		float v2 = (float)((RationnalValue) this).numerateur / (float)((RationnalValue) this).denominateur; 
		
		return new BooleanValue(v2 > v1);
	}

	@Override
	public BooleanValue inferior(NumericalValue v) throws IncompatibleTypeException {
		if (!(v instanceof NumericalValue)) {
			throw new IncompatibleTypeException();
		}
		
		float v1 = (float)((RationnalValue) v).numerateur / (float)((RationnalValue) v).denominateur; 
		float v2 = (float)((RationnalValue) this).numerateur / (float)((RationnalValue) this).denominateur; 
		
		return new BooleanValue(v2 < v1);
	}

	@Override
	public BooleanValue equality(NumericalValue v) throws IncompatibleTypeException {
		if (!(v instanceof NumericalValue)) {
			throw new IncompatibleTypeException();
		}
		
		float v1 = (float)((RationnalValue) v).numerateur / (float)((RationnalValue) v).denominateur; 
		float v2 = (float)((RationnalValue) this).numerateur / (float)((RationnalValue) this).denominateur; 
		return new BooleanValue(v1 == v2);
	
	}
}
