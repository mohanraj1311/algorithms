package edu.osu.cse.dynamic;

public class Fibonacci {

	public static int recursive(int n) {
		if( n == 0 ) {
			return 0;
		}
		
		if( n == 1) {
			return 1;
		}
		
		if( n == 2) {
			return 1;
		}
		
		return recursive(n - 1) + recursive(n - 2);
	}
	
	
	public static int[] cache = new int[256];
	public static int dynamic(int n) {
		if( n == 0 ) {
			return 0;
		}
		
		if( n == 1) {
			return 1;
		}
		
		if( n == 2) {
			return 1;
		}
		
		if(cache[n] != 0) {
			return cache[n];
		}
		
		return cache[n] = recursive(n - 1) + recursive(n - 2);
	}
}
