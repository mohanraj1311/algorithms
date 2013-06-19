package edu.osu.cse;

public class BitManipulation {

	public static int integralBase2(int n) {
		if(n < 1) {
			throw new RuntimeException("n cannot be negative or 0");
		}
		
		if(n == 1) return 0;
		
		int result = 0;
		while ((n = n >> 1) > 0) {
			result++;
		}
		return result - 1;
	}
}
