package edu.osu.cse.dynamic;

/**
 * Given a rod of length n inches and an array of prices that contains prices of
 * all pieces of size smaller than n. Determine the maximum value obtainable by
 * cutting up the rod and selling the pieces. For example, if length of the rod
 * is 8 and the values of different pieces are given as following, then the
 * maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * 
 * 
 * length | 1	2	3	4	5	6	7	8 
 * ----------------------------------------
 * price  | 1	5	8	9	10	17	17	20
 * 
 * Recurrence: 
 * 
 * 	cost[i] = max { cost[i], p[j] + cost[i - j]
 * @author prasanthj
 * 
 */
public class RodCutting {

	public static int getMaxCostIterative(int[] p, int len) {
		int[] cost = new int[len+1]; // stores the max cost for each rod lengths

		cost[0] = 0; // boundary condition
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= i; j++) {
				cost[i] = Math.max(cost[i], p[j-1] + cost[i - j]);
			}
		}
		return cost[len];
	}

	public static void main(String[] args) {
		//int[] p = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 }; // optimal soln: 22
		int[] p = new int[] { 3, 5, 8, 9, 10, 17, 17, 20 }; // optimal soln: 24

		int maxCost = getMaxCostIterative(p, 8);
		System.out.println("Max cost: " + maxCost);
	}
}
