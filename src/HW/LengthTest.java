package HW;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LengthTest {

	Length l1 = new Length(10, LengthUnit.M);
	Length l2 = new Length(1000, LengthUnit.CM);
	Length l3 = new Length(20, LengthUnit.M);
	
	@Test
	void testToString()
	{
		assertEquals("10M", l1.toString());
		assertEquals("1000CM", l2.toString());
	}
	
	@Test
	void testPlus()
	{
		Length res = new Length(20, LengthUnit.M);
		assertEquals(res, l1.plus(l2));

		res = new Length(2000, LengthUnit.CM);
		assertEquals(res, l2.plus(l1));
		
		assertThrows(ArithmeticException.class, () -> {
			Length len = new Length(Integer.MAX_VALUE, LengthUnit.M); 
			len.plus(len);
		});
		
		assertThrows(IllegalArgumentException.class, () -> l1.plus(null));
	}
	
	@Test
	void testMinus()
	{
		Length res = new Length(0, LengthUnit.M);
		assertEquals(res, l1.minus(l2));

		res = new Length(0, LengthUnit.CM);
		assertEquals(res, l2.minus(l1));
		
		res = new Length(10, LengthUnit.M);
		assertEquals(res, l1.minus(l3));
		
		assertThrows(IllegalArgumentException.class, () -> l1.minus(null));
	}
	
	@Test
	void testConvert()
	{
		assertEquals(l2, l1.convert(LengthUnit.CM));
		assertEquals(l1, l2.convert(LengthUnit.M));
		assertEquals(l2, l2.convert(null));
	}
	
	@Test
	void testBetween()
	{
		assertEquals(-10000, LengthUnit.MM.between(l3, l2), 0.00001);
		assertEquals(10, LengthUnit.M.between(l2, l3), 0.00001);
		assertEquals(-1000, LengthUnit.CM.between(l3, l2), 0.00001);
	}

	@Test
	void testEquals()
	{
		Length l4 = new Length(10, LengthUnit.M);
		assertTrue(l1.equals(l4));
		assertFalse(l1.equals(null));
		assertTrue(l1.equals(l2));
		assertFalse(l1.equals(l3));
	}

}
