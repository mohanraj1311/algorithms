package edu.osu.cse;

import java.util.Random;

public class KnuthShuffle {

	public static void shuffle(int[] a) {
		int n = a.length;
		Random rand = new Random();

		for (int i = 0; i < n; i++) {
			int sIdx = i + rand.nextInt(n - i);
			swap(a, i, sIdx);
		}
	}

	private static void swap(int[] a, int i, int sIdx) {
		int temp = a[i];
		a[i] = a[sIdx];
		a[sIdx] = temp;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		shuffle(a);
		for (int val : a) {
			System.out.print(val + " ");
		}
	}
}
