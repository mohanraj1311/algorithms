package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBitManipulation {

	@Test
	public void testIntegralBase2() {
		assertEquals(0, BitManipulation.integralBase2(1));
		assertEquals(0, BitManipulation.integralBase2(2));
		assertEquals(1, BitManipulation.integralBase2(5));
		assertEquals(2, BitManipulation.integralBase2(10));
		assertEquals(3, BitManipulation.integralBase2(20));
		assertEquals(3, BitManipulation.integralBase2(25));
		assertEquals(4, BitManipulation.integralBase2(40));
	}
}
