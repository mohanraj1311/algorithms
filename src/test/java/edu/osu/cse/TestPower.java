package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPower {

	@Test
	public void testPower() {
		assertEquals(4.0, Power.pow(2, 2), 0.0001);
		assertEquals(1.0, Power.pow(2, 0), 0.0001);
		assertEquals(2.0, Power.pow(2, 1), 0.0001);
		assertEquals(0.0, Power.pow(0, 2), 0.0001);
		assertEquals(8.0, Power.pow(2, 3), 0.0001);
		assertEquals(2048.0, Power.pow(2, 11), 0.0001);
		assertEquals(0.0625, Power.pow(2, -4), 0.0001);
	}
}
