package edu.osu.cse;

//check if a string contains unique characters

//Unicode(>8bits) or ASCII (8 bits)? 

public class UniqueCharInString {

	public static boolean checkUniqueness(String inp) {
		if (inp == null || inp.length() <= 1)
			return true;

		// assuming ASCII
		boolean[] check = new boolean[256];

		for (int i = 0; i < inp.length(); i++) {
			int c = inp.charAt(i);
			if (check[c]) {
				return false;
			}
			check[c] = true;
		}

		return true;
	}

	// will work for lower case alphabets only
	public static boolean checkUniqueness2(String inp) {
		if (inp == null || inp.length() <= 1)
			return true;

		// assuming ASCII
		int check = 0;

		for (int i = 0; i < inp.length(); i++) {
			int c = inp.charAt(i) - 'a';
			if ((check & (1 << c)) == 1) {
				return false;
			}
			check |= (1 << c);
		}

		return true;
	}

}
