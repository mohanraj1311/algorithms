package edu.osu.cse;

import java.util.Arrays;
import java.util.Random;

// given a list of integers, find all the triplets whose SUM is less than X. Assume triplets are distinct
// and their order doesn't matter. <1, 2, 3> is same as <1, 3, 2>.
// Naive solution is to choose 1st value and choose 2nd value while maintaining the constraint (sum<X)
// and then search the remaining space for 3rd value satisfying the constraint. This solution is in the
// order of O(n^3).

// Better solution is to first sort the array which will take O(n logn) time.
// Once the array is sorted, we can prune the elements that are greater than X.
// If the array contains only distinct elements, then have 1st pointer at
// 1st element and 2nd pointer at 2nd element. Now compute X - (1st + 2nd) = Y.
// Since the array is sorted we can easily locate the end position i.e, last element
// that is <= Y. Now that we have start and end position, we need to emit all triplets
// within this window. 
// i <- startIdx
// j <- startIdx + 1
// k <- endIdx
// if elements i + j + k <= X then emit, 
// if elements i + j + k > X then k--
public class TripletSum {

	public static void printTriplets(int[] inp, int X) {
		Arrays.sort(inp);

		int endIdx = inp.length;
		for (int i = 0; i < inp.length; i++) {
			if (inp[i] > X) {
				endIdx = i;
				break;
			}
		}

		int j = 0;
		int k = endIdx;
		for (int i = 0; i < endIdx; i++) {
			// since all elements in triplets should be distinct start with i+1
			j = i+1;  
			while (k >= j) {
				if(inp[i] + inp[j] + inp[k] <= X) {
					System.out.println(inp[i] + "-" + inp[j] + "-" + inp[k]);
				} else if(inp[i] + inp[j] + inp[k] > X) {
					k--;
				}
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] inp = new int[100];
		Random rand = new Random(100);
		
		for(int i=0; i<inp.length; i++) {
			inp[i] = rand.nextInt(100);
		}
		
		printTriplets(inp, 30);
	}
}
