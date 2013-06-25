package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHammingDistance {

	@Test
	public void testHM() {
		assertEquals(3, HammingDistance.hammingDistance("toned", "roses"));
		assertEquals(3, HammingDistance.hammingDistance("2173896", "2233796"));
		assertEquals(2, HammingDistance.hammingDistance(93, 73));
	}
}
