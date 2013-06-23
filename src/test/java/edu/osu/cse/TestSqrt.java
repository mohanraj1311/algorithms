package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSqrt {

	@Test
	public void testSqrt(){
		assertEquals(2.0, Sqrt.sqrt(4), 0.001);
		assertEquals(3.0, Sqrt.sqrt(9), 0.001);
		assertEquals(4.0, Sqrt.sqrt(16), 0.001);
		assertEquals(5.0, Sqrt.sqrt(25), 0.001);
		
		assertEquals(2.0, Sqrt.sqrt2(4), 0.001);
		assertEquals(3.0, Sqrt.sqrt2(9), 0.001);
		assertEquals(4.0, Sqrt.sqrt2(16), 0.001);
		assertEquals(5.0, Sqrt.sqrt2(25), 0.001);
	}
}
