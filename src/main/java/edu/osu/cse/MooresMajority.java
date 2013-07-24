package edu.osu.cse;

// ALgorithm here http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
public class MooresMajority {

	public static char currentChar = '?';
	public static int count = 0;
	
	public static char getMajority(String str) {

		for(int i=0; i<str.length(); i++) {
			if(currentChar == '?' && count == 0) {
				currentChar = str.charAt(i);
				count += 1;
			} else if (str.charAt(i) == currentChar) {
				count += 1;
			} else {
				count -= 1;
				if(count == 0) {
					currentChar = '?';
				}
			}
		}
		return currentChar;
	}
	
	public static void main(String[] args) {
		System.out.println(MooresMajority.getMajority("ABABABABAAABB"));
	}
}
