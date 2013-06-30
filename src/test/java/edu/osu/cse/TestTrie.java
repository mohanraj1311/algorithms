package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.osu.cse.trees.Trie;

public class TestTrie {

	@Test
	public void testTrie() {
		Trie trie = new Trie();
		trie.add("prasanth");
		trie.add("jayachandran");
		trie.add("jeyachandran");
		trie.add("prasanthjayachandran");
		trie.add("vasugi");
		trie.add("vasuki");
		trie.add("pras");
		
		assertEquals(true, trie.find("prasanth"));
		assertEquals(true, trie.find("jayachandran"));
		assertEquals(true, trie.find("jeyachandran"));
		assertEquals(true, trie.find("prasanthjayachandran"));
		assertEquals(true, trie.find("vasugi"));
		assertEquals(true, trie.find("vasuki"));
		assertEquals(true, trie.find("pras"));
		
		assertEquals(false, trie.find("niranjana"));
		assertEquals(false, trie.find("vasukij"));
		assertEquals(false, trie.find("prasan"));
	}
}
