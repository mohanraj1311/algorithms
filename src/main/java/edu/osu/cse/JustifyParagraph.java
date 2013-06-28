package edu.osu.cse;

import java.util.ArrayList;
import java.util.List;

public class JustifyParagraph {

	private static final int MIN_THRESHOLD = 5;

	public static String leftJustify(String para, int width) {
		if (para == null || para.isEmpty() || width <= MIN_THRESHOLD) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		int currentLen = 0;
		for (String word : para.split(" ")) {
			if (word.length() + currentLen > width) {
				sb.append("|\n");
				currentLen = 0;
			}
			sb.append(word);
			sb.append(" ");
			currentLen += word.length() + 1;
		}

		return sb.toString();
	}

	public static String leftAndRightJustify(String para, int width) {
		if (para == null || para.isEmpty() || width <= MIN_THRESHOLD) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		List<String> buffer = new ArrayList<String>();

		int spaceCount = 0;
		int currentLen = 0;
		for (String word : para.split(" ")) {
			if (word.length() + currentLen > width) {
				spaceCount += (width - currentLen);
				sb.append(justify(buffer, spaceCount));
				currentLen = 0;
				spaceCount = 0;
				buffer.clear();
			}
			buffer.add(word);
			spaceCount += 1;
			currentLen += word.length() + 1;
		}

		if (buffer.size() > 0) {
			for (String word : buffer) {
				sb.append(word);
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	private static String justify(List<String> buffer, int spaceCount) {
		String output = "";
		int validWords = buffer.size() - 1;
		int residue = spaceCount % validWords;
		int spaceBtwWords = spaceCount / validWords;
		for (int i = 0; i < validWords; i++) {
			if (i <= residue) {
				String temp = buffer.get(i);
				String spaces = "";
				for (int j = 0; j < spaceBtwWords + 1; j++) {
					spaces += " ";
				}
				buffer.set(i, temp + spaces);
			} else {
				String temp = buffer.get(i);
				String spaces = "";
				for (int j = 0; j < spaceBtwWords; j++) {
					spaces += " ";
				}
				buffer.set(i, temp + spaces);
			}
		}

		for (String s : buffer) {
			output += s;
		}
		return output + "|\n";
	}
}
