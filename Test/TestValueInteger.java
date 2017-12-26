package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Exception.IncompatibleTypeException;
import Value.BooleanValue;
import Value.IntegerValue;
import Value.RationnalValue;

public class TestValueInteger {

	@Test
	public void testIntegerValueParse() {

		String s1 = "5";
		IntegerValue iv1 = new IntegerValue();
		assertEquals(true, iv1.parse(s1));

		String s2 = "-5";
		IntegerValue iv2 = new IntegerValue();
		assertEquals(true, iv2.parse(s2));

		String s3 = null;
		IntegerValue iv3 = new IntegerValue();
		assertEquals(false, iv3.parse(s3));

		String s4 = "Bonjour";
		IntegerValue iv4 = new IntegerValue();
		assertEquals(false, iv4.parse(s4));

		String s5 = "false";
		IntegerValue iv5 = new IntegerValue();
		assertEquals(false, iv5.parse(s5));

		String s6 = "5.0";
		IntegerValue iv6 = new IntegerValue();
		assertEquals(false, iv6.parse(s6));

		String s7 = "0";
		IntegerValue iv7 = new IntegerValue();
		assertEquals(true, iv7.parse(s7));
	}

	@Test
	public void testIntegerValueAdd() throws IncompatibleTypeException {
		IntegerValue iv1 = new IntegerValue(5);
		IntegerValue iv2 = new IntegerValue(10);
		IntegerValue expected1 = new IntegerValue(15);

		assertEquals(expected1.toString(), iv1.add(iv2).toString());

		IntegerValue iv3 = new IntegerValue(-5);
		IntegerValue iv4 = new IntegerValue(-10);
		IntegerValue expected2 = new IntegerValue(-15);

		assertEquals(expected2.toString(), iv3.add(iv4).toString());

		IntegerValue iv5 = new IntegerValue(-5);
		IntegerValue iv6 = new IntegerValue(10);
		IntegerValue expected3 = new IntegerValue(5);

		assertEquals(expected3.toString(), iv5.add(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(5, 3);
			IntegerValue iv8 = new IntegerValue(10);
			IntegerValue expected4 = new IntegerValue(5);

			assertEquals(expected4.toString(), iv7.add(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testIntegerValueSubstract() throws IncompatibleTypeException {
		IntegerValue iv1 = new IntegerValue(5);
		IntegerValue iv2 = new IntegerValue(10);
		IntegerValue expected1 = new IntegerValue(5);

		assertEquals(expected1.toString(), (iv1.substract(iv2)).toString());

		IntegerValue iv3 = new IntegerValue(-5);
		IntegerValue iv4 = new IntegerValue(-10);
		IntegerValue expected2 = new IntegerValue(-5);

		assertEquals(expected2.toString(), iv3.substract(iv4).toString());

		IntegerValue iv5 = new IntegerValue(-5);
		IntegerValue iv6 = new IntegerValue(10);
		IntegerValue expected3 = new IntegerValue(15);

		assertEquals(expected3.toString(), iv5.substract(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(5, 3);
			IntegerValue iv8 = new IntegerValue(10);
			IntegerValue expected4 = new IntegerValue(5);

			assertEquals(expected4.toString(), iv7.substract(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testIntegerValueDivide() throws IncompatibleTypeException {
		IntegerValue iv1 = new IntegerValue(5);
		IntegerValue iv2 = new IntegerValue(10);
		IntegerValue expected1 = new IntegerValue(2);

		assertEquals(expected1.toString(), (iv1.divide(iv2)).toString());

		IntegerValue iv3 = new IntegerValue(-5);
		IntegerValue iv4 = new IntegerValue(-10);
		IntegerValue expected2 = new IntegerValue(2);

		assertEquals(expected2.toString(), iv3.divide(iv4).toString());

		IntegerValue iv5 = new IntegerValue(-5);
		IntegerValue iv6 = new IntegerValue(10);
		IntegerValue expected3 = new IntegerValue(-2);

		assertEquals(expected3.toString(), iv5.divide(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(5, 3);
			IntegerValue iv8 = new IntegerValue(10);
			IntegerValue expected4 = new IntegerValue(5);

			assertEquals(expected4.toString(), iv7.divide(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testIntegerValueMultiply() throws IncompatibleTypeException {
		IntegerValue iv1 = new IntegerValue(5);
		IntegerValue iv2 = new IntegerValue(10);
		IntegerValue expected1 = new IntegerValue(50);

		assertEquals(expected1.toString(), (iv1.multiply(iv2)).toString());

		IntegerValue iv3 = new IntegerValue(-5);
		IntegerValue iv4 = new IntegerValue(-10);
		IntegerValue expected2 = new IntegerValue(50);

		assertEquals(expected2.toString(), iv3.multiply(iv4).toString());

		IntegerValue iv5 = new IntegerValue(-5);
		IntegerValue iv6 = new IntegerValue(10);
		IntegerValue expected3 = new IntegerValue(-50);

		assertEquals(expected3.toString(), iv5.multiply(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(5, 3);
			IntegerValue iv8 = new IntegerValue(10);
			IntegerValue expected4 = new IntegerValue(5);

			assertEquals(expected4.toString(), iv7.multiply(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testIntegerValueSuperior() throws IncompatibleTypeException {
		IntegerValue iv1 = new IntegerValue(5);
		IntegerValue iv2 = new IntegerValue(10);
		BooleanValue expected1 = new BooleanValue(true);

		assertEquals(expected1.toString(), (iv1.superior(iv2)).toString());

		IntegerValue iv3 = new IntegerValue(-5);
		IntegerValue iv4 = new IntegerValue(-10);
		BooleanValue expected2 = new BooleanValue(false);

		assertEquals(expected2.toString(), iv3.superior(iv4).toString());

		IntegerValue iv5 = new IntegerValue(-5);
		IntegerValue iv6 = new IntegerValue(10);
		BooleanValue expected3 = new BooleanValue(true);

		assertEquals(expected3.toString(), iv5.superior(iv6).toString());

		try {
			IntegerValue iv7 = new IntegerValue(10);
			RationnalValue iv8 = new RationnalValue(5, 3);
			BooleanValue expected4 = new BooleanValue(true);

			assertEquals(expected4.toString(), iv7.superior(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testIntegerValueInferior() throws IncompatibleTypeException {
		IntegerValue iv1 = new IntegerValue(5);
		IntegerValue iv2 = new IntegerValue(10);
		BooleanValue expected1 = new BooleanValue(false);

		assertEquals(expected1.toString(), (iv1.inferior(iv2)).toString());

		IntegerValue iv3 = new IntegerValue(-5);
		IntegerValue iv4 = new IntegerValue(-10);
		BooleanValue expected2 = new BooleanValue(true);

		assertEquals(expected2.toString(), iv3.inferior(iv4).toString());

		IntegerValue iv5 = new IntegerValue(-5);
		IntegerValue iv6 = new IntegerValue(10);
		BooleanValue expected3 = new BooleanValue(false);

		assertEquals(expected3.toString(), iv5.inferior(iv6).toString());

		try {
			IntegerValue iv7 = new IntegerValue(10);
			RationnalValue iv8 = new RationnalValue(5, 3);
			BooleanValue expected4 = new BooleanValue(true);

			assertEquals(expected4.toString(), iv7.inferior(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testIntegerValueEquality() throws IncompatibleTypeException {
		IntegerValue iv1 = new IntegerValue(5);
		IntegerValue iv2 = new IntegerValue(10);
		BooleanValue expected1 = new BooleanValue(false);

		assertEquals(expected1.toString(), (iv1.equality(iv2)).toString());

		IntegerValue iv3 = new IntegerValue(-5);
		IntegerValue iv4 = new IntegerValue(-10);
		BooleanValue expected2 = new BooleanValue(false);

		assertEquals(expected2.toString(), iv3.equality(iv4).toString());

		IntegerValue iv5 = new IntegerValue(10);
		IntegerValue iv6 = new IntegerValue(10);
		BooleanValue expected3 = new BooleanValue(true);

		assertEquals(expected3.toString(), iv5.equality(iv6).toString());

		try {
			IntegerValue iv7 = new IntegerValue(10);
			RationnalValue iv8 = new RationnalValue(5, 3);
			BooleanValue expected4 = new BooleanValue(false);

			assertEquals(expected4.toString(), iv7.equality(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testIntegerValueAbs() throws IncompatibleTypeException {
		IntegerValue iv1 = new IntegerValue(5);
		IntegerValue expected1 = new IntegerValue(5);

		assertEquals(expected1.toString(), (iv1.abs()).toString());

		IntegerValue iv3 = new IntegerValue(-5);
		IntegerValue expected2 = new IntegerValue(5);
		
		assertEquals(expected2.toString(), iv3.abs().toString());

		IntegerValue iv5 = new IntegerValue(0);
		IntegerValue expected3 = new IntegerValue(0);
		
		assertEquals(expected3.toString(), iv5.abs().toString());
	}

}
