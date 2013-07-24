package edu.osu.cse.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a path in a graph, the solution is to find independent subset of graph
 * i.e, selected vertices should not be adjacent to each other and the sum of
 * weights of vertices in the independent subset should be maximum.
 * 
 * Example: 1->4->5->4
 * 
 * Solution: 8 NOTE: This solution only yields the optimal value but not the
 * optimal path that yielded the optimal value. To get the optimal path then use
 * the reconstruction algorithm.
 * 
 * Optimal Path: 4->4
 * 
 * @author prasanthj
 * 
 */
public class MaxWeightIndependentSet {

	public static int getOptimalValueMWIS(int[] path) {
		int[] cache = new int[path.length];

		// base cases
		cache[0] = path[0];
		cache[1] = Math.max(path[0], path[1]);

		// at every step either include the last element (in which case
		// the pen-ultimate element cannot be include) or discard the
		// last element. Consider the subproblem which yields the
		// maximum sum.
		// NOTE: This solution only gives the optimal value and not the
		// optimal solution (the exact nodes in the path)
		for (int i = 2; i < path.length; i++) {
			cache[i] = Math.max(cache[i - 1], cache[i - 2] + path[i]);
		}

		return cache[path.length - 1];
	}

	public static List<Integer> getOptimalPathMWIS(int[] path) {
		int[] cache = new int[path.length];
		List<Integer> optPath = new ArrayList<Integer>();

		// base cases
		cache[0] = path[0];
		cache[1] = Math.max(path[0], path[1]);

		// at every step either include the last element (in which case
		// the pen-ultimate element cannot be include) or discard the
		// last element. Consider the subproblem which yields the
		// maximum sum.
		// NOTE: This solution only gives the optimal value and not the
		// optimal solution (the exact nodes in the path)
		for (int i = 2; i < path.length; i++) {
			cache[i] = Math.max(cache[i - 1], cache[i - 2] + path[i]);
		}

		// reconstruction algorithm
		// Examine from the last element of the cache which has the
		// optimal value and then find from which case the optimal value
		// came from (case 1 - where last element is not included or
		// case 2 - where last element is included but pen-ultimate element is
		// not)
		for (int i = cache.length - 1; i >= 1; i--) {
			if (cache[i] > (cache[i - 1] + path[i])) {
				// case 1 wins
				continue;
			} else {
				// case 2 wins
				optPath.add(path[i]);
				i--; // skip another element since case 2 doesn't consider
						// pen-ultimate element
			}
		}
		return optPath;
	}

	public static void main(String[] args) {
		int[] inp = new int[8];
		inp[0] = 1;
		inp[1] = 4;
		inp[2] = 5;
		inp[3] = 4;
		inp[4] = 3;
		inp[5] = 6;
		inp[6] = 1;
		inp[7] = 4;

		int out = getOptimalValueMWIS(inp);
		System.out.println("Optimal Value: " + out);
		
		List<Integer> path = getOptimalPathMWIS(inp);
		System.out.println("Optimal Path: " + path.toString());
	}
}
