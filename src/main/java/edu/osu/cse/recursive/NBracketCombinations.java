package edu.osu.cse.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NBracketCombinations {

	// three positions to insert ()
	// -- insert at front
	// -- insert at back
	// -- insert after every open bracket '('
	public static Set<String> brackets(int remaining) {
		Set<String> set = new HashSet<String>();
		if (remaining == 0) {
			set.add("");
		} else {
			Set<String> prevSet = brackets(remaining - 1);
			for (String s : prevSet) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '(') {
						String out = insertAfter(s, i);
						set.add(out);
					}
				}

				// add () at first
				if (!set.contains("()" + s)) {
					set.add("()" + s);
				}

				// add () at last
				if (!set.contains(s + "()")) {
					set.add(s + "()");
				}
			}
		}

		return set;
	}

	private static String insertAfter(String s, int i) {
		String first = s.substring(0, i + 1);
		String last = s.substring(i + 1);
		return first + "()" + last;
	}

	// same strings are generated again
	// generate string from scratch
	// if leftRemaining brackets is >0 then insert '(' at index
	// if rightRemaining is >leftRemaining then insert ')' at index
	// if both becomes 0 then create a string out of buffer
	public static void bracketEfficient(ArrayList<String> out, int leftRemaining,
	    int rightRemaining, char[] str, int index) {
		if (leftRemaining < 0 || rightRemaining < leftRemaining) {
			return;
		}

		if (leftRemaining == 0 && rightRemaining == 0) {
			String s = String.copyValueOf(str);
			out.add(s);
		} else {
			if (leftRemaining > 0) {
				str[index] = '(';
				bracketEfficient(out, leftRemaining - 1, rightRemaining, str, index + 1);
			}

			if (rightRemaining > leftRemaining) {
				str[index] = ')';
				bracketEfficient(out, leftRemaining, rightRemaining - 1, str, index + 1);
			}
		}
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println(brackets(n));
		ArrayList<String> out = new ArrayList<String>();
		char[] buffer = new char[n * 2];
		bracketEfficient(out, n, n, buffer, 0);
		System.out.println(out);
	}
}
