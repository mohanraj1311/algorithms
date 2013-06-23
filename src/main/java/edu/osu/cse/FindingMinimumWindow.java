package edu.osu.cse;

// http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
// Input: String - ADOBECODEBANC
//        Chars - ABC
// Find the minimum window in the given string that contains all the chars in
// ANY order
public class FindingMinimumWindow {

	public static String findMinimumWindow(String inp, String pattern) {

		if (inp == null || inp.isEmpty()) {
			return inp;
		}

		if (pattern == null || pattern.isEmpty() || pattern.length() == 1) {
			return inp;
		}

		if (inp.equals(pattern)) {
			return inp;
		}

		String output = "";

		// 2 dictionaries
		// 1 - holds the count of characters in pattern
		// 2 - holds the count of characters that we found so far in the pattern
		int[] toFind = new int[256]; // assuming ASCII
		int[] found = new int[256];

		// prepare the dictionary
		for (char c : pattern.toCharArray()) {
			toFind[c] += 1;
		}

		// algorithm
		// constraint => found[c] >= toFind[c]
		// 1 - identify the sliding window that meets the constraint and
		// remember
		// its length
		// 2 - continue sliding the window until we find more characters from
		// pattern than we required while still maintaining window constraint
		// 3 - shrink the window (move start) by moving start, continue moving
		// start as long as constraint is maintained
		int start = 0;
		int end = 0;

		// position the start to first valid character
		while (toFind[inp.charAt(start)] == 0) {
			start++;
		}

		end = start;

		int count = 0;
		while (end < inp.length()) {
			char c = inp.charAt(end);
			if (toFind[c] != 0) {
				found[c] += 1;

				// don't count the excess elements
				if (found[c] <= toFind[c]) {
					count += 1;
				}

				// window length constraint met
				if (count == pattern.length()) {
					if (output.isEmpty() == true) {
						output = inp.substring(start, end + 1);
					} else {
						if (inp.substring(start, end + 1).length() < output
								.length()) {
							output = inp.substring(start, end + 1);
						}
					}

					// shift the start of window while maintaining the
					// constraint (found character should not fall below toFind)
					if ((inp.charAt(start) == c) && found[c] > toFind[c]) {
						found[c] -= 1;
						start++;
						char startChar = inp.charAt(start);
						// skip the character if it doesn't exist in the dict
						// skip if it exists but in excess
						while (toFind[startChar] == 0
								|| found[startChar] > toFind[startChar]) {
							if (found[startChar] > toFind[startChar]) {
								found[startChar] -= 1;
							}
							start++;
							startChar = inp.charAt(start);
						}

						// now that window start is shifted while the constraint
						// still holds, window size should have become lesser
						if (inp.substring(start, end + 1).length() < output
								.length()) {
							output = inp.substring(start, end + 1);
						}
					}
				}
			}
			end += 1;
		}
		return output;
	}
}
