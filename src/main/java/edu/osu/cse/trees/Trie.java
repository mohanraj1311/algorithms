package edu.osu.cse.trees;

import java.util.HashMap;

public class Trie {

	public class TrieNode {
		private boolean isSentinel;
		private HashMap<Character, TrieNode> map;

		public TrieNode(boolean isSentinel) {
			this.isSentinel = isSentinel;
			this.map = new HashMap<Character, TrieNode>();
		}

		public HashMap<Character, TrieNode> getMap() {
			return map;
		}

		@Override
		public String toString() {
			return isSentinel + " : " + map.toString();
		}

		public void setSentinel(boolean b) {
			this.isSentinel = true;
		}
	}

	public TrieNode root = new TrieNode(false);

	public void add(String key) {
		if (key == null) {
			return;
		}
		TrieNode currentNode = root;

		for (int i = 0; i < key.length(); i++) {
			char currChar = key.charAt(i);
			if (i == key.length() - 1) {
				// if the current node contains the key then make the current
				// node as sentinel which marks the end of a word else create
				// a new node an mark it as sentinel
				if (currentNode.getMap().containsKey(currChar)) {
					currentNode = currentNode.getMap().get(currChar);
					currentNode.setSentinel(true);
				} else {
					TrieNode newNode = new TrieNode(true);
					currentNode.getMap().put(currChar, newNode);
				}
			} else {
				// if the current node contains the key then descend down
				// else create a new node and the put the new node in the
				// current nodes map against the current matched character
				if (currentNode.getMap().containsKey(currChar)) {
					currentNode = currentNode.getMap().get(currChar);
				} else {
					TrieNode newNode = new TrieNode(false);
					currentNode.getMap().put(currChar, newNode);
					currentNode = newNode;
				}
			}
		}
	}

	public boolean find(String key) {
		if (key == null) {
			return false;
		}

		TrieNode currentNode = root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			if (i == key.length() - 1) {
				// if its a last character, then check if its the sentinel node
				// if so return true else false
				if (currentNode.getMap().containsKey(c)
						&& currentNode.getMap().get(c).isSentinel) {
					return true;
				} else {
					return false;
				}
			} else {
				// if any node contains the current char then descend a level
				// if the current char is not found then the word cannot be found
				if (currentNode.getMap().containsKey(c)) {
					currentNode = currentNode.getMap().get(c);
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
