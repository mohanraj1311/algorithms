package edu.osu.cse;

import org.junit.Test;

public class TestJustify {

	private static final int width = 40;
	@Test
	public void testLJ() {
		
		String para = "Cracking the Coding Interview: 150 Programming Interview Questions and Answers focuses on mastering the programming interview. Topics include: strategies to handle tough algorithm questions, preparation techniques, behavioral questions, and 150 programming interview questions and answers.";
		System.out.println(JustifyParagraph.leftJustify(para, width));
		for(int i=0; i<width; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	@Test
	public void testLRJ() {
		String para = "Cracking the Coding Interview: 150 Programming Interview Questions and Answers focuses on mastering the programming interview. Topics include: strategies to handle tough algorithm questions, preparation techniques, behavioral questions, and 150 programming interview questions and answers.";
		System.out.println(JustifyParagraph.leftAndRightJustify(para, width));
		for(int i=0; i<width; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
