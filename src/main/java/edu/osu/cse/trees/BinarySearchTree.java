package edu.osu.cse.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	public Node root = null;

	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public BinarySearchTree() {
		
	}
	
	public int getDepth(Node r) {
		if (r == null) {
			return -1;
		}

		return Math.max(getDepth(r.left), getDepth(r.right)) + 1;
	}

	public int getMinDepth(Node r) {
		if (r == null) {
			return -1;
		}

		return 1 + Math.min(getMinDepth(r.left), getMinDepth(r.right));
	}

	public int getMinDepthBFS(Node r) {
		int depth = 0;
		Queue<Node> queue = new LinkedList<Node>();
		Node dummy = new Node(-99999);
		queue.add(r);
		queue.add(dummy);
		while(true) {
			Node node;
			depth++;
			while(!(node = queue.remove()).equals(dummy)) {
				if(node.left == null && node.right == null) {
					return depth;
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
		}
	}
	
	public void levelOrderPrinting(Node r, int n) {
		Node dummy = new Node(-99999);
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(r);
		queue.add(dummy);
		
		int idx = 0;
		while(idx != n) {
			Node node;
			System.out.print("Level " + idx + ": ");
			while(!(node = queue.remove()).equals(dummy)) {
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				System.out.print(node.val + " ");
			}
			System.out.println();
			if(node.equals(dummy)) {
				queue.add(dummy);
			}
			idx++;
		}
	}
	
	public void addValues(int... vals) {
		for (int v : vals) {
			if (root == null) {
				root = new Node(v);
			} else {
				addImpl(root, v);
			}
		}
	}

	private void addImpl(Node r, int v) {
		if (r == null) {
			return;
		}
		
		if (v < r.val) {
			if (r.left == null) {
				r.left = new Node(v);
			} else {
				addImpl(r.left, v);
			}
		} else {
			if (r.right == null) {
				r.right = new Node(v);
			} else {
				addImpl(r.right, v);
			}
		}
	}
}
