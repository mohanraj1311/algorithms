package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStrings {

	@Test
	public void testStrings() {
		assertEquals("prasanth".indexOf("san"), Strings.indexOf("prasanth", "san"));
		assertEquals("prasanth".indexOf("nth"), Strings.indexOf("prasanth", "nth"));
		assertEquals("prasanth".indexOf("p"), Strings.indexOf("prasanth", "p"));
		assertEquals("prasanth".indexOf("j"), Strings.indexOf("prasanth", "j"));
	}
}
