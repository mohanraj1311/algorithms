package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.osu.cse.dynamic.Fibonacci;

public class TestFibonacci {

	@Test
	public void testFib() {
		assertEquals(3, Fibonacci.recursive(4));
		assertEquals(5, Fibonacci.recursive(5));
		assertEquals(8, Fibonacci.recursive(6));
		assertEquals(13, Fibonacci.recursive(7));
		
		assertEquals(3, Fibonacci.dynamic(4));
		assertEquals(5, Fibonacci.dynamic(5));
		assertEquals(8, Fibonacci.dynamic(6));
		assertEquals(13, Fibonacci.dynamic(7));
	}
}
