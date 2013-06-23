package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFindingMinimumWindow {

	@Test
	public void testMW() {
		assertEquals("BANC", FindingMinimumWindow.findMinimumWindow("ADOBECODEBANC", "ABC"));
		assertEquals("BANC", FindingMinimumWindow.findMinimumWindow("ADOBECODEBANCER", "ABC"));
		assertEquals("BCA", FindingMinimumWindow.findMinimumWindow("ADOBBBBBBBEASFSDSBCAODEBANCER", "ABC"));
		assertEquals("baca", FindingMinimumWindow.findMinimumWindow("acbbaca", "aba"));
	}
}
