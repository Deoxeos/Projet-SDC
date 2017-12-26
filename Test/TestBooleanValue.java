package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Exception.IncompatibleTypeException;
import Value.BooleanValue;

class TestBooleanValue {

	@Test
	void testBooleanValueEt() throws IncompatibleTypeException {
		BooleanValue bv1 = new BooleanValue(false);
		BooleanValue bv2 = new BooleanValue(true);
		BooleanValue expected1 = new BooleanValue(false);

		assertEquals(expected1.toString(), bv1.etLogique(bv2).toString());

		BooleanValue bv3 = new BooleanValue(false);
		BooleanValue bv4 = new BooleanValue(false);
		BooleanValue expected2 = new BooleanValue(false);

		assertEquals(expected2.toString(), bv3.etLogique(bv4).toString());

		BooleanValue bv5 = new BooleanValue(true);
		BooleanValue bv6 = new BooleanValue(true);
		BooleanValue expected3 = new BooleanValue(true);

		assertEquals(expected3.toString(), bv5.etLogique(bv6).toString());
	}

	@Test
	void testBooleanValueOu() throws IncompatibleTypeException {
		BooleanValue bv1 = new BooleanValue(false);
		BooleanValue bv2 = new BooleanValue(true);
		BooleanValue expected1 = new BooleanValue(true);

		assertEquals(expected1.toString(), bv1.ouLogique(bv2).toString());

		BooleanValue bv3 = new BooleanValue(false);
		BooleanValue bv4 = new BooleanValue(false);
		BooleanValue expected2 = new BooleanValue(false);

		assertEquals(expected2.toString(), bv3.ouLogique(bv4).toString());

		BooleanValue bv5 = new BooleanValue(true);
		BooleanValue bv6 = new BooleanValue(true);
		BooleanValue expected3 = new BooleanValue(true);

		assertEquals(expected3.toString(), bv5.ouLogique(bv6).toString());
	}

	@Test
	void testBooleanValueNeg() throws IncompatibleTypeException {
		BooleanValue bv1 = new BooleanValue(false);
		BooleanValue expected1 = new BooleanValue(true);

		assertEquals(expected1.toString(), bv1.negLogique().toString());

		BooleanValue bv3 = new BooleanValue(false);
		BooleanValue expected2 = new BooleanValue(true);

		assertEquals(expected2.toString(), bv3.negLogique().toString());
	}

	@Test
	public void testBooleanValueParse() {
		String s1 = "true";
		BooleanValue bv1 = new BooleanValue();

		assertEquals(true, bv1.parse(s1));

		String s2 = "false";
		BooleanValue bv2 = new BooleanValue();

		assertEquals(true, bv2.parse(s2));

		String s3 = "Bonjour";
		BooleanValue bv3 = new BooleanValue();

		assertEquals(false, bv3.parse(s3));
	}

	@Test
	public void testBooleanValueisTrue() {
		BooleanValue bv1 = new BooleanValue(true);

		assertEquals(true, bv1.isTrue());

		BooleanValue bv2 = new BooleanValue(false);

		assertEquals(false, bv2.isTrue());

	}

}
