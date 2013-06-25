package edu.osu.cse.dynamic;

public class EditDistance {

	public static int editDistRecursive(String s, String t) {
		if (s == null && t == null) {
			return -1;
		}

		if (s == null || s.length() == 0) {
			return t.length();
		}

		if (t == null || t.length() == 0) {
			return s.length();
		}

		int cost = -1;
		// compare last characters if they are equal
		if (s.charAt(s.length() - 1) == t.charAt(t.length() - 1)) {
			cost = 0;
		} else {
			cost = 1;
		}

		return Math.min(
				editDistRecursive(s, t.substring(0, t.length() - 1)) + 1, Math
						.min(editDistRecursive(s.substring(0, s.length() - 1),
								t) + 1,
								editDistRecursive(
										s.substring(0, s.length() - 1),
										t.substring(0, t.length() - 1))
										+ cost));
	}

	public static int editDistIterative(String s, String t) {
		if (s == null || t == null) {
			return -1;
		}
		int n = s.length();
		int m = t.length();
		int[][] lev = new int[n][m];

		for (int i = 0; i < n; i++) {
			lev[i][0] = i;
		}

		for (int i = 0; i < m; i++) {
			lev[0][i] = i;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					// cost is 0
					lev[i][j] = lev[i - 1][j - 1];
				} else {
					// add 1 cost if they are not equal
					lev[i][j] = Math.min(lev[i][j - 1] + 1,
							Math.min(lev[i - 1][j] + 1, lev[i - 1][j - 1] + 1));
				}
			}
		}
		return lev[n-1][m-1];
	}
}
