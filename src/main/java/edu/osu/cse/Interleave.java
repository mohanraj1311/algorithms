package edu.osu.cse;

public class Interleave {

	public static boolean interleave(String a, String b, String c) {
		if(c.length() == a.length()) {
			if(c.equals(a)) {
				return true;
			}
			
			return false;
		}
		
		if(c.length() == b.length()) {
			if(c.equals(b)) {
				return true;
			}
			
			return false;
		}
		
		for(int i=0; i < c.length(); i++) {
			String s = c.substring(0, i);
			String e = c.substring(i+1);
			System.out.println(interleave(a, b, s + e));
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(Interleave.interleave("xyz", "abc", "xyabzc"));
	}
}
