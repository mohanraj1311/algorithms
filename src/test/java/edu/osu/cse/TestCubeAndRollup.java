package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCubeAndRollup {

	@Test
	public void testCube() {
		List<String> expected = new ArrayList<String>();
		expected.add("abc");
		expected.add("***");
		expected.add("ab*");
		expected.add("a*c");
		expected.add("*bc");
		expected.add("a**");
		expected.add("**c");
		expected.add("*b*");
		
		List<String> actual = CubeAndRollup.computeCube("abc");
		
		for(String s : actual) {
			assertEquals(true, expected.contains(s));
		}
		
		List<String> expectedRollup = new ArrayList<String>();
		expectedRollup.add("abcd");
		expectedRollup.add("****");
		expectedRollup.add("abc*");
		expectedRollup.add("ab**");
		expectedRollup.add("a***");
		List<String> rollup = CubeAndRollup.computeRollup("abcd");
		for(String s : rollup) {
			assertEquals(true, expectedRollup.contains(s));
		}
	}
}
