package edu.osu.cse;

/**
 * Display an integer array of [1, 2, 3, 4, 5, 6, 7] in the following format
 * 
 * 1 4 6 2 5 7 3
 * 
 * The method signature takes in an array of integers and the number of columns.
 * In the above example, noOfCols = 3. The columns should contain equal number
 * of elements as much as possible.
 * 
 * @author pjayachandran
 * 
 */
public class PrintLine {

	public static int printLine(int[] inp, int width) {
		if (inp == null || width < 1) {
			return -1;
		}

		int numRows = (int) Math.ceil(inp.length / width);
		int numResidue = inp.length % width;
		int jump = 0;

		int i = 0;
		for (i = 0; i < numRows; i++) {
			int n = 1;
			int nr = numResidue;
			System.out.print(inp[i] + " ");
			jump = 0;
			while (n != width) {
				if (nr > 0) {
					jump = (jump + numRows) + 1;
					nr--;
				} else {
					jump = (jump + numRows);
				}
				System.out.print(inp[i + jump] + " ");
				n++;
			}
			System.out.println();
		}

		jump = 0;
		if (numResidue > 0) {
			System.out.print(inp[i] + " ");
			numResidue--;
			jump = (jump + numRows) + 1;
			while (numResidue > 0) {
				System.out.print(inp[i + jump] + " ");
				numResidue--;
			}
			System.out.println();
		}
		return 0;
	}

	public static void main(String[] args) {
		printLine(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }, 3);
	}
}
