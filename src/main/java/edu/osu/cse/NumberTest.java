package edu.osu.cse;

public class NumberTest {

	public static boolean isNumber(String inp) {
		if (inp == null || inp.isEmpty()) {
			return false;
		}

		boolean isDecimal = false;
		for (int i = 0; i < inp.length(); i++) {
			char c = inp.charAt(i);
			if (c == '+' || c == '-') {
				// sign should occur at fist position
				if (i != 0) {
					return false;
				}
			} else if (c == '.') {
				// encountered decimal already
				if (isDecimal) {
					return false;
				} else {
					isDecimal = true;
				}

				// decimal cannot be at the last position
				if (i == inp.length() - 1) {
					return false;
				}
			} else if (c < '0' || c > '9') {
				// not a numeral
				return false;
			}
		}

		return true;
	}
}
