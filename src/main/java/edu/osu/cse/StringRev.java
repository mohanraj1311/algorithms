package edu.osu.cse;

public class StringRev {

	public static String reverseRecursive(String test) {
		return reverseRecursiveImpl(test);
	}
	
	private static String reverseRecursiveImpl(String str) {
		if(str.length() == 0) return "";
		if(str.length() == 1) return str;
		return str.charAt(str.length()-1) + reverseRecursive(str.substring(1, str.length()-1)) + str.charAt(0);
	}

	public static void main(String[] args) {
		String name = "prasanthj";
		System.out.println(StringRev.reverseRecursive(name));
	}
}
