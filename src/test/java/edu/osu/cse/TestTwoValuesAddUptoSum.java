package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTwoValuesAddUptoSum {

	@Test
	public void testTV() {
		assertEquals(0, TwoValuesAddUptoSum.find(new int[]{2,3,4,5,6,7,8,9}, 10));
		assertEquals(-1, TwoValuesAddUptoSum.find(new int[]{2,3,4,5,6,7,8,9}, 100));
		assertEquals(0, TwoValuesAddUptoSum.find(new int[]{2,3,4,5,6,7,8,9,-9}, 0));
		
		assertEquals(0, TwoValuesAddUptoSum.find2(new int[]{2,3,4,5,6,7,8,9}, 10));
		assertEquals(-1, TwoValuesAddUptoSum.find2(new int[]{2,3,4,5,6,7,8,9}, 100));
		assertEquals(0, TwoValuesAddUptoSum.find2(new int[]{2,3,4,5,6,7,8,9,-9}, 0));
	}
}
