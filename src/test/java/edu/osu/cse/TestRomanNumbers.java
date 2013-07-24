package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRomanNumbers {

	@Test
	public void testRN(){
		assertEquals(-1, RomanNumerals.toNumber("IIII"));
		assertEquals(-1, RomanNumerals.toNumber("IIIY"));
		assertEquals(40, RomanNumerals.toNumber("XL"));
		assertEquals(4, RomanNumerals.toNumber("IV"));
		assertEquals(8, RomanNumerals.toNumber("VIII"));
		assertEquals(19, RomanNumerals.toNumber("XIX"));
		assertEquals(28, RomanNumerals.toNumber("XXVIII"));
		assertEquals(45, RomanNumerals.toNumber("XLV"));
		assertEquals(890, RomanNumerals.toNumber("DCCCXC"));
		assertEquals(88, RomanNumerals.toNumber("LXXXVIII"));
		
		assertEquals("XL", RomanNumerals.toRoman(40));
		assertEquals("IV", RomanNumerals.toRoman(4));
		assertEquals("VIII", RomanNumerals.toRoman(8));
		assertEquals("XIX", RomanNumerals.toRoman(19));
		assertEquals("XXVIII", RomanNumerals.toRoman(28));
		assertEquals("XLV", RomanNumerals.toRoman(45));
		assertEquals("DCCCXC", RomanNumerals.toRoman(890));
		assertEquals("LXXXVIII", RomanNumerals.toRoman(88));
	}
}
