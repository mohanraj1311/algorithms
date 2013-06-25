package edu.osu.cse;

public class HammingDistance {

	public static int hammingDistance(String s, String t) {
		if(s == null || t == null || s.isEmpty() || t.isEmpty()) {
			return -1;
		}
		
		if(s.length() != t.length()) {
			return -1;
		}
		
		int dist = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) != t.charAt(i)) {
				dist++;
			}
		}
		
		return dist;
	}
	
	public static int hammingDistance(int x, int y) {
		int dist = 0;
		int xor = x ^ y;
		
		while(xor > 0) {
			if((xor & 1) == 1) {
				dist++;
			}
			
			xor = xor >>> 1;
		}
		
		return dist;
	}
}
