package edu.osu.cse.dynamic;

public class LongestCommonSubsequence {

	public static int getLCSValue(String s1, String s2) {
		int lcs = 0;
		String[] seq1 = s1.split(",");
		String[] seq2 = s2.split(",");

		int n = seq1.length;

		// This algorithm proceeds from right to left of both strings.
		// L(i,j) = { L(i-1, j-1) + 1 if s1[i] = s2[j] or
		// { max(L[i,j-1], L[i-1,j] if s1[i] != s2[j])
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (seq1[i - 1].equals(seq2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		lcs = dp[n][n];
		return lcs;
	}

	public static String[] getLCSPath(String s1, String s2) {
		String[] seq1 = s1.split(",");
		String[] seq2 = s2.split(",");

		int n = seq1.length;

		// This algorithm proceeds from right to left of both strings.
		// L(i,j) = { L(i-1, j-1) + 1 if s1[i] = s2[j] or
		// { max(L[i,j-1], L[i-1,j] if s1[i] != s2[j])
		int[][] dp = new int[n + 1][n + 1];
		char[][] path = new char[n + 1][n + 1];
		String[] lcsp = new String[n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = 0;
				path[i][j] = '*';
				lcsp[i] = "*";
			}
		}

		// case a) When the sequence match then store '\' to indicate
		// 1 element is skipped in each sequence (i-1, j-1).
		// case b) if second sequence is skipped by 1 element when there
		// is mismatch as in case b) we store '-' to indicate
		// the change in j i.e, (i, j-1).
		// case c) if first sequence is skipped by 1 element when there
		// is change in i i.e, (i-1, j) then we use '|' to indicate change 
		// in i (thinks of these symbols in 2D matrix) Refer. Cormen book
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (seq1[i - 1].equals(seq2[j - 1])) {
					// case a)
					dp[i][j] = dp[i - 1][j - 1] + 1;
					path[i][j] = '\\';
				} else if (dp[i][j - 1] >= dp[i - 1][j]) {
					// case b)
					dp[i][j] = dp[i][j - 1];
					path[i][j] = '-';
				} else {
					// case c)
					dp[i][j] = dp[i - 1][j];
					path[i][j] = '|';
				}
			}
		}

		// This emits the matching sequence in reverse order.
		// To emit in the correct order rewrite this solution
		// in recursive way.
		int i = n;
		int j = n;
		int idx = 0;
		while (i >= 1 && j >= 1) {
			if (path[i][j] == '\\') {
				i--;
				j--;
				lcsp[idx] = seq1[i];
				idx++;
			} else if (path[i][j] == '-') {
				j--;
			} else if (path[i][j] == '|') {
				i--;
			}
		}
		
		return lcsp;
	}

	public static void main(String[] args) {
		String s1 = "P,R,A,S,A,N,T,H";
		String s2 = "P,R,A,Y,E,R,S,T";
//		 String s1 = "A,B,C,B,D,A,B";
//		 String s2 = "B,D,C,A,B,A,F";
//		String s1 = "A,C,C,G,G,T,C,G,A,G,T,G,C,G,C,G,G,A,A,G,C,C,G,G,C,C,G,A,A";
//		String s2 = "G,T,C,G,T,T,C,G,G,A,A,T,G,C,C,G,T,T,G,C,T,C,T,G,T,A,A,A,X";

		int lcsv = getLCSValue(s1, s2);
		System.out.println(lcsv);

		String[] lcsp = getLCSPath(s1, s2);
		for (String l : lcsp) {
			if (l.equals("*") == false) {
				System.out.print(l);
			}
		}
	}
}
