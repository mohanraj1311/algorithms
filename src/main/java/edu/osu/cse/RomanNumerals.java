package edu.osu.cse;

public class RomanNumerals {

	// prepare dictionary
	public static int[] dict = new int[256];
	public static int[] invDict = new int[7];
	public static char[] invDict2 = new char[1001];

	private static void initialize() {
		dict['I'] = 1;
		dict['V'] = 5;
		dict['X'] = 10;
		dict['L'] = 50;
		dict['C'] = 100;
		dict['D'] = 500;
		dict['M'] = 1000;

		invDict[0] = 1;
		invDict[1] = 5;
		invDict[2] = 10;
		invDict[3] = 50;
		invDict[4] = 100;
		invDict[5] = 500;
		invDict[6] = 1000;

		invDict2[1] = 'I';
		invDict2[5] = 'V';
		invDict2[10] = 'X';
		invDict2[50] = 'L';
		invDict2[100] = 'C';
		invDict2[500] = 'D';
		invDict2[1000] = 'M';
	}

	public static String toRoman(int x) {
		String out = "";
		if (x < 1 || x > 3999) {
			return out;
		}

		initialize();

		int[] tokens = new int[String.valueOf(x).length()];
		int mod = 10;
		int idx = 0;
		while (x > 0) {
			tokens[idx] = x % mod;
			x -= tokens[idx];
			mod *= 10;
			idx++;
		}

		for (int i = idx - 1; i >= 0; i--) {
			int val = tokens[i];

			// if 10's place then first 3 elements are relevant, if 100's places
			// then 2-4 elements are relevant from invDict2
			int minIdx = i * 2;
			int min = invDict[minIdx];
			int min2 = invDict[minIdx + 1];
			int min3 = invDict[minIdx + 2];

			// if the value is just below min3 then add min and min3.
			// ex: if value is 9 then use I and X
			if (val + min == min3) {
				out += invDict2[min];
				out += invDict2[min3];
				val = 0;
			} else if (val >= min2) {
				// if the value is between min2 and (min3 - min) then add min2
				// and remove min2 from value
				// ex: if value is 8, then add V and change the value to 3
				out += invDict2[min2];
				val -= min2;
			}

			// if the value is just below min2 then add min and min2
			// ex: if value is 4 then use IV
			if (val + min == min2) {
				out += invDict2[min];
				out += invDict2[min2];
			} else {
				// if the value is between min and (min2 - min) then repeat min
				// ex: 3 will be III
				while (val > 0) {
					out += invDict2[min];
					val -= min;
				}
			}
		}
		
		return out;
	}

	public static int toNumber(String r) {
		int out = 0;

		initialize();
		int[] sum = new int[r.length()];
		int idx = 0;
		char prev = '0';
		int count = 0;
		for (char c : r.toCharArray()) {
			if (dict[c] == 0) {
				return -1;
			} else {
				if (prev == '0') {
					prev = c;
					count = 1;
				}

				if (c == prev) {
					count++;
				} else {
					count = 0;
					prev = c;
				}

				// same character repeated more than 3 times, so invalid
				if (count > 3) {
					return -1;
				}
				sum[idx] = dict[c];
				if (idx != 0 && sum[idx] > sum[idx - 1]) {
					sum[idx - 1] = sum[idx] - sum[idx - 1];
					sum[idx] = 0;
					idx--;
				}
				idx++;
			}
		}

		for (int i : sum) {
			out += i;
		}
		return out;
	}
}
