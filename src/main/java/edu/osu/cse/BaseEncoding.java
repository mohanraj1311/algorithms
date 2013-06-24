package edu.osu.cse;

public class BaseEncoding {

	private final static String baseTable = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String base64chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

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

		int totalChars = input.toCharArray().length;
		int leftOverBytes = totalChars % 3;

		// assuming ASCII string
		StringBuilder sb = new StringBuilder();
		int mask = (1 << 6) - 1;
		for (int i = 0; i < (totalChars - leftOverBytes);) {
			int char1 = (0xff & input.charAt(i)) << 16;
			int char2 = (0xff & input.charAt(i + 1)) << 8;
			int char3 = 0xff & input.charAt(i + 2);
			int val = char1 | char2 | char3;
			int offset = 3;
			while (offset > -1) {
				int tempVal = (val >>> (offset * 6)) & mask;
				sb.append(base64chars.charAt(tempVal));
				offset -= 1;
			}
			i = i + 3;
		}

		if (leftOverBytes > 0) {
			if (leftOverBytes == 1) {
				int offset = 1;
				int val = (0xff & input.charAt(totalChars - 1)) << 4;
				while (offset > -1) {
					int tempVal = (val >>> (offset * 6)) & mask;
					sb.append(base64chars.charAt(tempVal));
					offset -= 1;
				}
				sb.append("=");
				sb.append("=");
			} else {
				int offset = 2;
				int char1 = (0xff & input.charAt(totalChars - 2)) << 10;
				int char2 = (0xff & input.charAt(totalChars - 1)) << 2;
				int val = char1 | char2;
				while (offset > -1) {
					int tempVal = (val >>> (offset * 6)) & mask;
					sb.append(base64chars.charAt(tempVal));
					offset -= 1;
				}
				sb.append("=");
			}
		}

		return sb.toString();
	}

	static String encode(int value, int base) {
		// unsupported base
		if (base < 0 || base > 64) {
			return null;
		}

		boolean isSigned = value < 0 ? true : false;
		StringBuilder sb = new StringBuilder();

		if(isSigned) {
			value = -value;
		}
		
		while (value > 0) {
			sb.append(baseTable.charAt(value % base));
			value = value / base;
		}
		if(isSigned) {
			return "-" + reverse(sb.toString());
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
	
	static int decode(String value, int base) {
		if(value == null || value.isEmpty()) {
			return -1;
		}
		value = value.toLowerCase();
		boolean isSigned = value.charAt(0) == '-' ? true: false;
		int output = 0;
		int startIdx = 0;
		if(isSigned) {
			startIdx = 1;
		}
		for(int i=startIdx; i<value.length(); i++) {
			int c = value.charAt(i);
			int val = baseTable.indexOf(c);
			output = output * base;
			output += val;
		}
		
		if(isSigned) {
			return -output;
		}
		return output;
	}
}
