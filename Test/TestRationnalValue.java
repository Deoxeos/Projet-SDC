package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Exception.IncompatibleTypeException;
import Value.BooleanValue;
import Value.IntegerValue;
import Value.RationnalValue;

public class TestRationnalValue {

	@Test
	void testRationnalValueParse() {

		String s1 = "5#1";
		RationnalValue iv1 = new RationnalValue();
		assertEquals(true, iv1.parse(s1));

		String s2 = "-5#1";
		RationnalValue iv2 = new RationnalValue();
		assertEquals(true, iv2.parse(s2));

		String s3 = null;
		RationnalValue iv3 = new RationnalValue();
		assertEquals(false, iv3.parse(s3));

		String s4 = "Bonjour";
		RationnalValue iv4 = new RationnalValue();
		assertEquals(false, iv4.parse(s4));

		String s5 = "false";
		RationnalValue iv5 = new RationnalValue();
		assertEquals(false, iv5.parse(s5));

		String s6 = "5";
		RationnalValue iv6 = new RationnalValue();
		assertEquals(false, iv6.parse(s6));

		String s7 = "0#0";
		RationnalValue iv7 = new RationnalValue();
		assertEquals(true, iv7.parse(s7));
	}

	@Test
	public void testRationnalValueAdd() throws IncompatibleTypeException {
		RationnalValue iv1 = new RationnalValue(5,1);
		RationnalValue iv2 = new RationnalValue(10,1);
		RationnalValue expected1 = new RationnalValue(15,1);

		assertEquals(expected1.toString(), iv1.add(iv2).toString());

		RationnalValue iv3 = new RationnalValue(-10,7);
		RationnalValue iv4 = new RationnalValue(-5,4);
		RationnalValue expected2 = new RationnalValue(75,-28);
		assertEquals(expected2.toString(), iv3.add(iv4).toString());

		RationnalValue iv5 = new RationnalValue(-5,3);
		RationnalValue iv6 = new RationnalValue(10,5);
		RationnalValue expected3 = new RationnalValue(1,3);

		assertEquals(expected3.toString(), iv5.add(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(5, 3);
			IntegerValue iv8 = new IntegerValue(10);
			RationnalValue expected4 = new RationnalValue(5,5);

			assertEquals(expected4.toString(), iv7.add(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testRationnalValueSubstract() throws IncompatibleTypeException {
		RationnalValue iv1 = new RationnalValue(5,1);
		RationnalValue iv2 = new RationnalValue(10,1);
		RationnalValue expected1 = new RationnalValue(-5,1);

		assertEquals(expected1.toString(), iv1.substract(iv2).toString());

		RationnalValue iv3 = new RationnalValue(-10,7);
		RationnalValue iv4 = new RationnalValue(-5,4);
		RationnalValue expected2 = new RationnalValue(-5,28);
		assertEquals(expected2.toString(), iv3.substract(iv4).toString());

		RationnalValue iv5 = new RationnalValue(-5,3);
		RationnalValue iv6 = new RationnalValue(10,5);
		RationnalValue expected3 = new RationnalValue(-11,3);

		assertEquals(expected3.toString(), iv5.substract(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(5, 3);
			IntegerValue iv8 = new IntegerValue(10);
			RationnalValue expected4 = new RationnalValue(5,5);

			assertEquals(expected4.toString(), iv7.substract(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testRationnalValueDivide() throws IncompatibleTypeException {
		RationnalValue iv1 = new RationnalValue(5,1);
		RationnalValue iv2 = new RationnalValue(10,1);
		RationnalValue expected1 = new RationnalValue(1,2);

		assertEquals(expected1.toString(), iv1.divide(iv2).toString());

		RationnalValue iv3 = new RationnalValue(-5,4);
		RationnalValue iv4 = new RationnalValue(-10,7);
		RationnalValue expected2 = new RationnalValue(7,8);
		assertEquals(expected2.toString(), iv3.divide(iv4).toString());

		RationnalValue iv5 = new RationnalValue(10,5);
		RationnalValue iv6 = new RationnalValue(-5,3);
		RationnalValue expected3 = new RationnalValue(6,-5);

		assertEquals(expected3.toString(), iv5.divide(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(5, 3);
			IntegerValue iv8 = new IntegerValue(10);
			RationnalValue expected4 = new RationnalValue(5,5);

			assertEquals(expected4.toString(), iv7.divide(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testRationnalValueMultiply() throws IncompatibleTypeException {
		RationnalValue iv1 = new RationnalValue(5,1);
		RationnalValue iv2 = new RationnalValue(10,1);
		RationnalValue expected1 = new RationnalValue(50,1);

		assertEquals(expected1.toString(), iv1.multiply(iv2).toString());

		RationnalValue iv3 = new RationnalValue(-5,4);
		RationnalValue iv4 = new RationnalValue(-10,7);
		RationnalValue expected2 = new RationnalValue(25,14);
		assertEquals(expected2.toString(), iv3.multiply(iv4).toString());

		RationnalValue iv5 = new RationnalValue(10,5);
		RationnalValue iv6 = new RationnalValue(-5,3);
		RationnalValue expected3 = new RationnalValue(10,-3);

		assertEquals(expected3.toString(), iv5.multiply(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(5, 3);
			IntegerValue iv8 = new IntegerValue(10);
			RationnalValue expected4 = new RationnalValue(5,5);

			assertEquals(expected4.toString(), iv7.multiply(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testRationnalValueSuperior() throws IncompatibleTypeException {
		RationnalValue iv1 = new RationnalValue(10,1);
		RationnalValue iv2 = new RationnalValue(5,1);
		BooleanValue expected1 = new BooleanValue(true);

		assertEquals(expected1.toString(), (iv1.superior(iv2)).toString());

		RationnalValue iv3 = new RationnalValue(-10,1);
		RationnalValue iv4 = new RationnalValue(-5,1);
		BooleanValue expected2 = new BooleanValue(false);

		assertEquals(expected2.toString(), iv3.superior(iv4).toString());

		RationnalValue iv5 = new RationnalValue(10,1);
		RationnalValue iv6 = new RationnalValue(-5,1);
		BooleanValue expected3 = new BooleanValue(true);

		assertEquals(expected3.toString(), iv5.superior(iv6).toString());

		try {
			RationnalValue iv7 = new RationnalValue(10,1);
			RationnalValue iv8 = new RationnalValue(5, 3);
			BooleanValue expected4 = new BooleanValue(true);

			assertEquals(expected4.toString(), iv7.superior(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testRationnalValueInferior() throws IncompatibleTypeException {
			RationnalValue iv1 = new RationnalValue(10,1);
			RationnalValue iv2 = new RationnalValue(5,1);
			BooleanValue expected1 = new BooleanValue(false);

			assertEquals(expected1.toString(), (iv1.inferior(iv2)).toString());

			RationnalValue iv3 = new RationnalValue(-10,1);
			RationnalValue iv4 = new RationnalValue(-5,1);
			BooleanValue expected2 = new BooleanValue(true);

			assertEquals(expected2.toString(), iv3.inferior(iv4).toString());

			RationnalValue iv5 = new RationnalValue(10,1);
			RationnalValue iv6 = new RationnalValue(-5,1);
			BooleanValue expected3 = new BooleanValue(false);

			assertEquals(expected3.toString(), iv5.inferior(iv6).toString());

			try {
				RationnalValue iv7 = new RationnalValue(10,1);
				RationnalValue iv8 = new RationnalValue(5, 3);
				BooleanValue expected4 = new BooleanValue(false);

				assertEquals(expected4.toString(), iv7.inferior(iv8).toString());
			} catch (Exception e) {
				assertEquals(IncompatibleTypeException.class, e.getClass());
			}
	}

	@Test
	public void testRationnalValueEquality() throws IncompatibleTypeException {
		RationnalValue iv1 = new RationnalValue(10,1);
		RationnalValue iv2 = new RationnalValue(5,1);
		BooleanValue expected1 = new BooleanValue(false);

		assertEquals(expected1.toString(), (iv1.equality(iv2)).toString());

		RationnalValue iv3 = new RationnalValue(-10,1);
		RationnalValue iv4 = new RationnalValue(10,1);
		BooleanValue expected2 = new BooleanValue(false);

		assertEquals(expected2.toString(), iv3.equality(iv4).toString());

		RationnalValue iv5 = new RationnalValue(10,1);
		RationnalValue iv6 = new RationnalValue(10,1);
		BooleanValue expected3 = new BooleanValue(true);

		assertEquals(expected3.toString(), iv5.equality(iv6).toString());

		try {
			IntegerValue iv7 = new IntegerValue(5);
			RationnalValue iv8 = new RationnalValue(10,1);
			BooleanValue expected4 = new BooleanValue(true);

			assertEquals(expected4.toString(), iv7.equality(iv8).toString());
		} catch (Exception e) {
			assertEquals(IncompatibleTypeException.class, e.getClass());
		}
	}

	@Test
	public void testRationnalValueAbs() throws IncompatibleTypeException {
		RationnalValue iv1 = new RationnalValue(5,1);
		RationnalValue expected1 = new RationnalValue(5,1);

		assertEquals(expected1.toString(), (iv1.abs()).toString());

		RationnalValue iv3 = new RationnalValue(-5,1);
		RationnalValue expected2 = new RationnalValue(5,1);
		
		assertEquals(expected2.toString(), iv3.abs().toString());

		RationnalValue iv5 = new RationnalValue(0,1);
		RationnalValue expected3 = new RationnalValue(0,1);
		
		assertEquals(expected3.toString(), iv5.abs().toString());
	}

}
