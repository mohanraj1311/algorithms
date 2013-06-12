package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMaxSubarray {

	@Test
	public void testMaxSubarrayPositive() {
		int[] inp = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		assertEquals(6, MaximumSubarray.maxSubarray(inp));
		assertEquals(3, MaximumSubarray.maxSubarrayWithIndex(inp).startIdx);
		assertEquals(6, MaximumSubarray.maxSubarrayWithIndex(inp).endIdx);
	}
	
	@Test
	public void testMaxSubarrayPositive2() {
		int[] inp = new int[]{-2, 1, -3, 4, -1, 2, -1, 5, 4};
		assertEquals(13, MaximumSubarray.maxSubarray(inp));
		assertEquals(3, MaximumSubarray.maxSubarrayWithIndex(inp).startIdx);
		assertEquals(8, MaximumSubarray.maxSubarrayWithIndex(inp).endIdx);
	}
	
	@Test
	public void testMaxSubarrayPositive3() {
		int[] inp = new int[]{-2, -1, -3, -4, -1, -2, -1, -5, 4};
		assertEquals(4, MaximumSubarray.maxSubarray(inp));
		assertEquals(8, MaximumSubarray.maxSubarrayWithIndex(inp).startIdx);
		assertEquals(8, MaximumSubarray.maxSubarrayWithIndex(inp).endIdx);
	}
	
	@Test
	public void testMaxSubarrayPositive4() {
		int[] inp = new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4};
		assertEquals(0, MaximumSubarray.maxSubarray(inp));
		assertEquals(0, MaximumSubarray.maxSubarrayWithIndex(inp).startIdx);
		assertEquals(0, MaximumSubarray.maxSubarrayWithIndex(inp).endIdx);
	}
}
