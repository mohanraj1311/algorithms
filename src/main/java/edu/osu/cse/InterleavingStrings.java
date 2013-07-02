package edu.osu.cse;

public class InterleavingStrings {

	public static void printAllInterleavings(String s, String t) {
		if(s == null || t == null) {
			return;
		}

		printAllInterleavingsImpl(s, t, "");
	}

	private static void printAllInterleavingsImpl(String s, String t,
			String prefix) {
		if(s.length() == 0 && t.length() == 0) {
			System.out.println(prefix);
			return;
		}
		
		if(s.length() != 0) {
			for(int i=0; i<s.length(); i++) {
				printAllInterleavingsImpl(s.substring(i+1), t, prefix + s.substring(0, i+1));
			}
		}
		
		if(t.length() != 0) {
			for(int i=0; i<t.length(); i++) {
				printAllInterleavingsImpl(s, t.substring(i+1), prefix + t.substring(0, i+1));
			}
		}
	}

	public static void main(String[] args) {
		printAllInterleavings("AB", "C");
	}
}
