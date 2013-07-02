package edu.osu.cse;

public class Strings {

	public static int indexOf(String src, String pat) {
		int idx = -1;
		if(src == null || src.isEmpty() || pat == null || pat.isEmpty() ) {
			return idx;
		}
		
		int pIdx = 0;
		int sIdx = 0;
		for(char c: src.toCharArray()) {
			if(c == pat.charAt(pIdx)) {
				if(idx == -1) {
					idx = sIdx;
				}
				pIdx++;
				
				if(pIdx == pat.length()) {
					return idx; 
				}
			} else {
				pIdx = 0;
			}
			sIdx++;
		}
		
		return idx;
	}
}
