package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringBinaryTreeDepth {

	@Test
	public void testDepth() {
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth(null));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth(""));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("()"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("x"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("0"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("()"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("(0)"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("(00)x"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("(0p)"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("(00)0"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("((00)(00)00"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("((0x)(0x)0x"));
		assertEquals(-1, StringBinaryTreeDepth.getTreeDepth("(000)"));
		
		assertEquals(0, StringBinaryTreeDepth.getTreeDepth("(00)"));
		assertEquals(1, StringBinaryTreeDepth.getTreeDepth("((00)0)"));
		assertEquals(1, StringBinaryTreeDepth.getTreeDepth("((00)(00))"));
		assertEquals(2, StringBinaryTreeDepth.getTreeDepth("((00)(0(00)))"));
		assertEquals(3, StringBinaryTreeDepth.getTreeDepth("((00)(0(0(00))))"));
	}
}
