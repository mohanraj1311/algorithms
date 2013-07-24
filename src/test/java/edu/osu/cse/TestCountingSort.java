package edu.osu.cse;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import edu.osu.cse.sort.CountingSort;

public class TestCountingSort {

	@Test
	public void testCountingSort() {
		assertArrayEquals(
				new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5 },
				CountingSort.countingSort(new int[] { 1, 5, 0, 5, 1, 1, 3, 0,
						2, 0, 4, 4, 1, 0, 2, 4 }));
	}
}
