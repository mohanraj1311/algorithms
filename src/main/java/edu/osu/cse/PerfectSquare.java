package edu.osu.cse;

// http://www.johndcook.com/blog/2008/11/17/fast-way-to-test-whether-a-number-is-a-square/
public class PerfectSquare {

	public static boolean isPerfectSquare(int n) {
		int h = n % 16;
		if(h > 9) {
			return false;
		}
		
		if(h == 0 || h == 1 || h == 4 || h == 9) {
			int sqrt = (int) Math.round(Sqrt.sqrt(n));
			return sqrt*sqrt == n;
		}
		return false;
	}
}
