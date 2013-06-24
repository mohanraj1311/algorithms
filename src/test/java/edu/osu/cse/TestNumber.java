package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNumber {

	@Test
	public void testNumber() {
		assertEquals(false, NumberTest.isNumber("----"));
		assertEquals(false, NumberTest.isNumber("-00000."));
		assertEquals(false, NumberTest.isNumber(""));
		assertEquals(false, NumberTest.isNumber(null));
		assertEquals(false, NumberTest.isNumber("-1-1-1"));
		assertEquals(false, NumberTest.isNumber("--1"));
		assertEquals(false, NumberTest.isNumber("1.1.2"));
		
		assertEquals(true, NumberTest.isNumber("-1"));
		assertEquals(true, NumberTest.isNumber("-0"));
		assertEquals(true, NumberTest.isNumber("-1.1"));
		assertEquals(true, NumberTest.isNumber("-11111.0"));
		assertEquals(true, NumberTest.isNumber("+192"));
		assertEquals(true, NumberTest.isNumber("00000.4"));
		assertEquals(true, NumberTest.isNumber("121"));
		assertEquals(true, NumberTest.isNumber("-123.1111"));
	}
 }
