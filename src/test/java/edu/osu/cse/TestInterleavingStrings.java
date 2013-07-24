package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestInterleavingStrings {

	@Test
	public void testInterleaving() {
		InterleavingStrings.printAllInterleavings("AB", "CD");
		
		assertEquals(true, InterleavingStrings.isInterleaved("AB", "CD", "ABCD"));
		assertEquals(true, InterleavingStrings.isInterleaved("AB", "CD", "ACBD"));
		assertEquals(true, InterleavingStrings.isInterleaved("AB", "CD", "ACDB"));
		assertEquals(true, InterleavingStrings.isInterleaved("AB", "CD", "CABD"));
		assertEquals(true, InterleavingStrings.isInterleaved("AB", "CD", "CADB"));
		assertEquals(true, InterleavingStrings.isInterleaved("AB", "CD", "CDAB"));
		assertEquals(false, InterleavingStrings.isInterleaved("AB", "CD", "CDAA"));
		assertEquals(false, InterleavingStrings.isInterleaved("AB", "CD", "CBAB"));
		assertEquals(false, InterleavingStrings.isInterleaved("AB", "CD", "CDCA"));
		assertEquals(false, InterleavingStrings.isInterleaved("AB", "C", "CDCA"));
		
		assertEquals(true, InterleavingStrings.isInterleaved2("AB", "CD", "ABCD"));
		assertEquals(true, InterleavingStrings.isInterleaved2("AB", "CD", "ACBD"));
		assertEquals(true, InterleavingStrings.isInterleaved2("AB", "CD", "ACDB"));
		assertEquals(true, InterleavingStrings.isInterleaved2("AB", "CD", "CABD"));
		assertEquals(true, InterleavingStrings.isInterleaved2("AB", "CD", "CADB"));
		assertEquals(true, InterleavingStrings.isInterleaved2("AB", "CD", "CDAB"));
		assertEquals(false, InterleavingStrings.isInterleaved2("AB", "CD", "CDAA"));
		assertEquals(false, InterleavingStrings.isInterleaved2("AB", "CD", "CBAB"));
		assertEquals(false, InterleavingStrings.isInterleaved2("AB", "CD", "CDCA"));
		assertEquals(false, InterleavingStrings.isInterleaved2("AB", "C", "CDCA"));
	}
}
