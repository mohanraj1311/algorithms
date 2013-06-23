package edu.osu.cse;

public class BaseEncoding {

	static char[] table = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z' };

	static char[] base64LT = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', '+', '/' };

	// Algorithm:
	// - Take 3 characters (24 bits) and split into 4*6 bits.
	// - Encode it with base64 table
	// - If the total number of characters is not divisible by 3 then do the
	// following
	// -- if there is only one leftover byte then add 4 bits to make it 12 bits
	// long. Append '=' to indicate one left over byte.
	// -- if there are 2 leftover bytes then add 2 bits to make it to 18 bits
	// long. Append '==' to indicate 2 left over bytes.
	static String base64Encode(String input) {
		if (input == null) {
			return null;
		}

		String cleanedInp = removeSpaces(input);
		int totalChars = cleanedInp.toCharArray().length;
		int leftOverBytes = totalChars % 3;

		// assuming ASCII string
		StringBuilder sb = new StringBuilder();
		int mask = (1 << 6) - 1;
		for (int i = 0; i < (totalChars - leftOverBytes);) {
			int char1 = (0xff & cleanedInp.charAt(i)) << 16;
			int char2 = (0xff & cleanedInp.charAt(i + 1)) << 8;
			int char3 = 0xff & cleanedInp.charAt(i + 2);
			int val = char1 | char2 | char3;
			int offset = 3;
			while (offset > -1) {
				int tempVal = (val >>> (offset * 6)) & mask;
				sb.append(base64LT[tempVal]);
				offset -= 1;
			}
			i = i + 3;
		}

		if (leftOverBytes > 0) {
			if (leftOverBytes == 1) {
				int offset = 1;
				int val = (0xff & cleanedInp.charAt(totalChars - 1)) << 4;
				while (offset > -1) {
					int tempVal = (val >>> (offset * 6)) & mask;
					sb.append(base64LT[tempVal]);
					offset -= 1;
				}
				sb.append("=");
				sb.append("=");
			} else {
				int offset = 2;
				int char1 = (0xff & cleanedInp.charAt(totalChars - 2)) << 10;
				int char2 = (0xff & cleanedInp.charAt(totalChars - 1)) << 2;
				int val = char1 | char2;
				while (offset > -1) {
					int tempVal = (val >>> (offset * 6)) & mask;
					sb.append(base64LT[tempVal]);
					offset -= 1;
				}
				sb.append("=");
			}
		}

		return sb.toString();
	}

	private static String removeSpaces(String input) {
		input.replaceAll("\n", "");
		input.replaceAll("\r", "");
		input.replaceAll(" ", "");
		return input;
	}

	static String encode(int value, int base) {
		// FIXME: handle negative numbers as well
		if (value < 0) {
			return null;
		}

		// unsupported base
		if (base < 0 || base > 64) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		while (value > 0) {
			sb.append(table[value % base]);
			value = value / base;
		}
		return reverse(sb.toString());
	}

	private static String reverse(String inp) {
		if (inp.length() <= 1) {
			return inp;
		}
		String start = inp.substring(0, 1);
		String end = inp.substring(inp.length() - 1);
		return end + reverse(inp.substring(1, inp.length() - 1)) + start;
	}
}
