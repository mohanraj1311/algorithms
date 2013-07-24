package edu.osu.cse;

public class InterleavingStrings {

	public static void printAllInterleavings(String a, String b) {
		if (a == null || b == null) {
			return;
		}

		if (a.isEmpty()) {
			System.out.println(b);
		}

		if (b.isEmpty()) {
			System.out.println(a);
		}

		printAllInterleavingsImpl(a, b, "");
	}

	private static void printAllInterleavingsImpl(String a, String b,
			String prefix) {
		// base cases
		if (a.isEmpty()) {
			System.out.println(prefix + b);
			return;
		}

		if (b.isEmpty()) {
			System.out.println(prefix + a);
			return;
		}

		// remove the first char and append it to prefix. we consider only the
		// 1st char since order matters in interleaving
		printAllInterleavingsImpl(a.substring(1), b, prefix + a.charAt(0));
		printAllInterleavingsImpl(a, b.substring(1), prefix + b.charAt(0));
	}

	public static boolean isInterleaved(String a, String b, String c) {
		if (a == null || b == null) {
			return false;
		}

		if (c.length() != (a.length() + b.length())) {
			return false;
		}

		return isInterleavedImpl(a, b, "", c);
	}

	public static boolean isInterleaved2(String a, String b, String c) {
		if (a == null || b == null) {
			return false;
		}

		if (c.length() != (a.length() + b.length())) {
			return false;
		}

		int n = c.length();
		int aIdx = 0;
		int bIdx = 0;
		int cIdx = 0;
		while (cIdx != n) {
			char ch = c.charAt(cIdx++);
			if (aIdx != a.length() && a.charAt(aIdx) == ch) {
				aIdx++;
			} else if (bIdx != b.length() && b.charAt(bIdx) == ch) {
				bIdx++;
			} else {
				// no match found
				return false;
			}
		}

		// if it came out of loop then all characters matched
		return true;
	}

	private static boolean isInterleavedImpl(String a, String b, String prefix,
			String c) {
		// base cases
		if (a.isEmpty()) {
			prefix += b;
			if (prefix.equals(c)) {
				return true;
			}
			return false;
		}

		if (b.isEmpty()) {
			prefix += a;
			if (prefix.equals(c)) {
				return true;
			}
			return false;
		}

		boolean out = isInterleavedImpl(a.substring(1), b,
				prefix + a.charAt(0), c);
		if (out == true) {
			return true;
		}
		out = isInterleavedImpl(a, b.substring(1), prefix + b.charAt(0), c);

		return out;
	}

}
