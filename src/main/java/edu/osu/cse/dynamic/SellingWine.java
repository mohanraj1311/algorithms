package edu.osu.cse.dynamic;

/**
 * Imagine you have a collection of N wines placed next to each other on a
 * shelf. For simplicity, let's number the wines from left to right as they are
 * standing on the shelf with integers from 1 to N, respectively. The price of
 * the i-th wine is pi (prices of different wines can be different).
 * 
 * Because the wines get better every year, supposing today is the year 1, on
 * year y the price of the i-th wine will be y*pi, i.e. y-times more than the
 * current year.
 * 
 * You want to sell all the wines you have, but you want to sell exactly one
 * wine per year, starting on this year. One more constraint - on each year you
 * are allowed to sell only either the leftmost or the rightmost wine on the
 * shelf and you are not allowed to reorder the wines on the shelf (i.e. they
 * must stay in the same order as they are in the beginning).
 * 
 * You want to find out, what is the maximum profit you can get, if you sell the
 * wines in optimal order.
 * 
 * So for example, if the prices of the wines are (in the order as they are
 * placed on the shelf, from left to right): p1=1, p2=4, p3=2, p4=3 The optimal
 * solution would be to sell the wines in the order p1, p4, p3, p2 for a total
 * profit 1*1 + 3*2 + 2*3 + 4*4 = 29
 * 
 * @author prasanthj
 * 
 */
public class SellingWine {

	private static int N = 5;
	private static int[] input;
	private static int[][] cache = new int[N][N];

	private static int getMaxProfitRecursive() {
		int be = 0;
		int en = input.length - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cache[i][j] = -1;
			}
		}
		return profit(be, en);
	}

	private static int profit(int be, int en) {
		if (en < be)
			return 0;

		if (cache[be][en] != -1)
			return cache[be][en];

		int year = N - (en - be + 1) + 1;
		return cache[be][en] = Math.max(profit(be + 1, en) + year * input[be],
				profit(be, en - 1) + year * input[en]);
	}

	public static void main(String[] args) {
		input = new int[] { 2, 3, 5, 1, 4 };

		int profit = getMaxProfitRecursive();
		System.out.println("Maximum profit: " + profit);
	}
}
