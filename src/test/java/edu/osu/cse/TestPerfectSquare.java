package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPerfectSquare {

	@Test
	public void testPerfectSquare() {
		assertEquals(false, PerfectSquare.isPerfectSquare(3));
		assertEquals(false, PerfectSquare.isPerfectSquare(5));
		assertEquals(false, PerfectSquare.isPerfectSquare(7));
		assertEquals(false, PerfectSquare.isPerfectSquare(11));
		assertEquals(false, PerfectSquare.isPerfectSquare(2));
		
		assertEquals(true, PerfectSquare.isPerfectSquare(1));
		assertEquals(true, PerfectSquare.isPerfectSquare(4));
		assertEquals(true, PerfectSquare.isPerfectSquare(9));
		assertEquals(true, PerfectSquare.isPerfectSquare(81));
		assertEquals(true, PerfectSquare.isPerfectSquare(225));
	}
}
