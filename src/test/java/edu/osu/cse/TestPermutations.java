package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestPermutations {

	@Test
	public void testPermutations() {
		assertEquals(false, Permutation.checkPermutation("abc", "ab"));
		assertEquals(false, Permutation.checkPermutation("abc", "ABC"));
		assertEquals(false, Permutation.checkPermutation("abc", ""));
		assertEquals(true, Permutation.checkPermutation("", ""));
		assertEquals(false, Permutation.checkPermutation(null, "ab"));
		assertEquals(false, Permutation.checkPermutation(null, null));
		assertEquals(true, Permutation.checkPermutation("abc", "cab"));
		assertEquals(true, Permutation.checkPermutation("AAA", "AAA"));
		assertEquals(true, Permutation.checkPermutation("abc", "cab"));
		assertEquals(true, Permutation.checkPermutation("abcde", "edcba"));
		
		assertEquals(false, Permutation.checkPermutation2("abc", "ab"));
		assertEquals(false, Permutation.checkPermutation2("abc", "ABC"));
		assertEquals(false, Permutation.checkPermutation2("abc", ""));
		assertEquals(true, Permutation.checkPermutation2("", ""));
		assertEquals(false, Permutation.checkPermutation2(null, "ab"));
		assertEquals(false, Permutation.checkPermutation2(null, null));
		assertEquals(true, Permutation.checkPermutation2("abc", "cab"));
		assertEquals(true, Permutation.checkPermutation2("AAA", "AAA"));
		assertEquals(true, Permutation.checkPermutation2("abc", "cab"));
		assertEquals(true, Permutation.checkPermutation2("abcde", "edcba"));
		
		Permutation.printAllPermutations("abcd");
		List<String> expected = new ArrayList<String>();
		expected.add("abc");
		expected.add("acb");
		expected.add("bca");
		expected.add("bac");
		expected.add("cba");
		expected.add("cab");
		List<String> actual = Permutation.getAllPermutations("abc");
		assertEquals(expected.size(), actual.size());
		for(String s: actual) {
			assertEquals(true, expected.contains(s));
		}
	}
}
