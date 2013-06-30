package edu.osu.cse.sort;

// http://www.cs.miami.edu/~burt/learning/Csc517.091/workbook/countingsort.html
public class CountingSort {

	public static int[] countingSort(int[] inp) {
		if(inp == null || inp.length < 2) {
			return inp;
		}
		
		int max = inp[0];
		for(int i:inp) {
			if(i>max) {
				max = i;
			}
		}
		
		int[] hist = new int[max+1];
		int[] output = new int[inp.length];
		
		// compute histogram
		for(int i:inp) {
			hist[i] += 1;
		}
		
		// accumlate histogram
		for(int i=1; i<hist.length; i++) {
			hist[i] = hist[i] + hist[i-1];
		}
		
		// fillup up the output array
		for(int i=inp.length-1; i>=0; i--) {
			int key = inp[i];
			int position = hist[key];
			hist[key] -= 1;
			output[position-1] = key;
		}
		
		return output;
	}
}
