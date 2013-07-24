package edu.osu.cse.recursive;

import java.util.Arrays;

// https://en.wikipedia.org/wiki/Eight_queens_puzzle
public class NQueens {

	private static int[] cache = null;

	public static void solveNQueens(int col, int n) {
		if (cache == null) {
			cache = new int[n];
			Arrays.fill(cache, -1);
		}

		for (int row = 0; row < n; row++) {
			if (isSafePlace(col, row)) {
				cache[row] = col;
				if (col == n) {
					print(cache);
				} else {
					solveNQueens(col + 1, n);
				}
			}
		}
	}

	private static void print(int[] cache) {
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache.length; j++) {
				if (cache[i] == j) {
					System.out.print("X ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}

	private static boolean isSafePlace(int row, int col) {
		for (int i = 0; i < row; i++) {
			if ((cache[i] == col) || (Math.abs(cache[i] - col) == Math.abs(i - row))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		solveNQueens(1, 4);
	}
}
