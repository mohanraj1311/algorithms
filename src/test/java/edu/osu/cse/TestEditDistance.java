package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.osu.cse.dynamic.EditDistance;

public class TestEditDistance {

	@Test
	public void testED() {
		assertEquals(3, EditDistance.editDistRecursive("kitten", "sitting"));
		assertEquals(3, EditDistance.editDistIterative("kitten", "sitting"));
	}
}
