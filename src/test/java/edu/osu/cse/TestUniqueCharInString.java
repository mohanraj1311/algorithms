package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUniqueCharInString {

	@Test
	public void testCases() {
		assertEquals(true, UniqueCharInString.checkUniqueness(null));
		assertEquals(true, UniqueCharInString.checkUniqueness("a"));
		assertEquals(false, UniqueCharInString.checkUniqueness("aa"));
		assertEquals(true, UniqueCharInString.checkUniqueness("ABCD"));
		assertEquals(true, UniqueCharInString.checkUniqueness("ABCDa"));
		assertEquals(false, UniqueCharInString.checkUniqueness("ABCDA"));
		assertEquals(false, UniqueCharInString.checkUniqueness("$$"));
		assertEquals(true, UniqueCharInString.checkUniqueness2("abc"));
		assertEquals(false, UniqueCharInString.checkUniqueness2("abca"));
	}
}
