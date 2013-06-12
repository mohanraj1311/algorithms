package edu.osu.cse;

// http://en.wikipedia.org/wiki/Maximum_subarray_problem
public class MaximumSubarray {

	public static class Result {
		public int val;
		public int startIdx;
		public int endIdx;
		
		public Result(int val, int sidx, int eidx) {
			this.val = val;
			this.startIdx = sidx;
			this.endIdx = eidx;
		}
	}
	
	public static int maxSubarray(int[] inp) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		for(int i=0; i<inp.length;i++) {
			maxEndingHere = Math.max(0, maxEndingHere + inp[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
	
	public static Result maxSubarrayWithIndex(int[] inp) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int sIdx = 0;
		int eIdx = 0;
		for(int i=0; i<inp.length;i++) {
			maxEndingHere = Math.max(0, maxEndingHere + inp[i]);
			if(maxEndingHere == 0) {
				sIdx = i;
			}
			if(maxEndingHere > maxSoFar) {
				eIdx = i;
			}
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
			
		}
		if(sIdx + 1 >= inp.length) {
			sIdx = 0;
			eIdx = 0;
		} else {
			sIdx += 1;
		}
		return new Result(maxSoFar, sIdx, eIdx);
	}
}
