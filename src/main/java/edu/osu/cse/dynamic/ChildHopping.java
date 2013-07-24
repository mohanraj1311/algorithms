package edu.osu.cse.dynamic;

import java.util.Arrays;

// A child is running up a staircase with n steps and can hop either 1, 2 or 3 
// steps at a time. Count how many possible ways the child can run up the stairs
public class ChildHopping {

	// each step in the staircase (from top to bottom) can be reached in 3
	// different
	// ways. Hence the complexity of recursive algorithm is O(3^N).
	public static long countWaysRecursive(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWaysRecursive(n - 1) + countWaysRecursive(n - 2)
			    + countWaysRecursive(n - 3);
		}
	}

	public static int[] cache = null;

	public static long countWaysDynamic(int n) {
		if (cache == null) {
			cache = new int[n + 1];
			Arrays.fill(cache, -1);
		}

		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (cache[n] > -1) {
			return cache[n];
		} else {
			cache[n] = (int) (countWaysDynamic(n - 1) + countWaysDynamic(n - 2) + countWaysDynamic(n - 3));
			return cache[n];
		}
	}

	public static void main(String[] args) {
		System.out.println("Recursive: " + countWaysRecursive(8));
		System.out.println("Dynamic: " + countWaysDynamic(8));
	}
}
