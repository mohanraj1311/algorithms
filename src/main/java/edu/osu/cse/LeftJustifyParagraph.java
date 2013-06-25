package edu.osu.cse;

public class LeftJustifyParagraph {

	private static final int MIN_THRESHOLD = 5;

	public static String leftJustify(String para, int width) {
		if(para == null || para.isEmpty() || width <= MIN_THRESHOLD) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		
		int currentLen = 0;
		for(String word: para.split(" ")) {
			
			if(word.length() + currentLen > width) {
				sb.append("\n");
				currentLen = 0;
			}
			sb.append(word);
			sb.append(" ");
			currentLen += word.length() + 1;
		}
		
		return sb.toString();
	}
}
