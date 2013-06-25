package edu.osu.cse;

import org.junit.Test;

public class TestLeftJustify {

	@Test
	public void testLJ() {
		String para = "Cracking the Coding Interview: 150 Programming Interview Questions and Answers focuses on mastering the programming interview. Topics include: strategies to handle tough algorithm questions, preparation techniques, behavioral questions, and 150 programming interview questions and answers.";
		System.out.println(LeftJustifyParagraph.leftJustify(para, 40));
	}
}
