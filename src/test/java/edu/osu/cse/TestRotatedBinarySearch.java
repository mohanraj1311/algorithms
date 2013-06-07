package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRotatedBinarySearch {

	@Test
	public void testNotRotated() {
		int[] inp = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		assertEquals(true, RotatedBinarySearch.search(inp, 5) != -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 50) == -1);
	}
	
	@Test
	public void testRotated() {
		int[] inp = new int[]{13,14,15,16,1,2,3,4,5,6,7,8,9,10,11,12};
		assertEquals(true, RotatedBinarySearch.search(inp, 1) != -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 4) != -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 5) != -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 11) != -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 12) != -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 13) != -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 16) != -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 0) == -1);
		assertEquals(true, RotatedBinarySearch.search(inp, 50) == -1);
	}
}
