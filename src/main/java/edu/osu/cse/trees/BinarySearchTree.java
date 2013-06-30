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
		
		@Override
		public String toString() {
			String out = "";
			out += val;
			out += " [left:" + left;
			out += "] [right:" + right + "]";
			return out;
		}
	}

	public BinarySearchTree() {

	}

	public int getDepth(Node r) {
		if (r == null) {
			return 0;
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
		int depth = -1;
		Queue<Node> queue = new LinkedList<Node>();
		Node dummy = new Node(-99999);
		queue.add(r);
		queue.add(dummy);
		while (true) {
			Node node;
			depth++;
			while (!(node = queue.remove()).equals(dummy)) {
				if (node.left == null && node.right == null) {
					return depth;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			// reinsert the dummy node and continue
			if (node.equals(dummy)) {
				queue.add(node);
			}
		}
	}

	// this solution is clean but not efficient. The time complexity is O(n^2) 
	// since get height function traverses the same subtree multiple times.
	public boolean isBalanced(Node r) {
		if(r == null) {
			return true;
		}
		
		int leftHeight = getDepth(r.left);
		int rightHeight = getDepth(r.right);
		if(Math.abs(leftHeight-rightHeight) > 1) {
			return false;
		} else {
			return isBalanced(r.left) && isBalanced(r.right);
		}
	}
	
	// this solution is more efficient than the previous one. In this the height
	// function also checks for tree balance. If the tree is not balanced the 
	// height function returns -1 else the proper height. The time complexity
	// of this function is O(N) since all elements are touched in the tree and
	// space complexity is O(log N) which is the space occupied by the stack
	public boolean isBalanced2(Node r) {
		if(checkHeight(r) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private int checkHeight(Node r) {
		if(r == null) {
			return 0;
		}
		
		int leftHeight = checkHeight(r.left);
		if(leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = checkHeight(r.right);
		if(rightHeight == -1) {
			return -1;
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(checkHeight(r.left), checkHeight(r.right)) + 1;
		}
	}

	public void levelOrderPrinting(Node r, int n) {
		Node dummy = new Node(-99999);
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(r);
		queue.add(dummy);

		int idx = 0;
		while (idx != n) {
			Node node;
			System.out.print("Level " + idx + ": ");
			while (!(node = queue.remove()).equals(dummy)) {
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				System.out.print(node.val + " ");
			}
			System.out.println();
			if (node.equals(dummy)) {
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

	public void inorder(Node r) {
		if (r == null) {
			return;
		}

		inorder(r.left);
		System.out.print(r.val + " ");
		inorder(r.right);
	}

	public void preorder(Node r) {
		if (r == null) {
			return;
		}

		System.out.print(r.val + " ");
		inorder(r.left);
		inorder(r.right);
	}

	public void postorder(Node r) {
		if (r == null) {
			return;
		}

		inorder(r.left);
		inorder(r.right);
		System.out.print(r.val + " ");
	}

	public void printAllPaths(Node r) {
		printAllPathsImpl(r, "/");
	}

	private void printAllPathsImpl(Node r, String prefix) {
		if (r == null) {
			return;
		}

		prefix += r.val + "/";
		if (r.left == null && r.right == null) {
			System.out.println(prefix);
		}
		printAllPathsImpl(r.left, prefix);
		printAllPathsImpl(r.right, prefix);
	}

	private static Node prev = null;

	public boolean isBST(Node r) {
		if (r == null) {
			return true;
		}

		if (!isBST(r.left)) {
			return false;
		}
		
		if (prev != null && prev.val > r.val) {
			return false;
		}

		prev = r;

		return isBST(r.right);
	}
	
	public boolean isBST2(Node r) {
		return isBST2Impl(r, null);
	}

	private boolean isBST2Impl(Node r, Node prev) {
		if(r == null) {
			return true;
		}
		
		if(r.left != null) {
			if(!isBST2Impl(r.left, r.left.left)) {
				return false;
			}
		}
		
		if(prev != null && prev.val > r.val) {
			return false;
		}
		
		return isBST2Impl(r.right, r);
	}
	
	public int findKthLargest(Node r, int k) {
		if(r == null) {
			return -1;
		}
		
		if(k > numNodes(r)) {
			return -1;
		}
		
		if(numNodes(r.right) + 1 == k) {
			return r.val;
		} else if(k > numNodes(r.right) + 1) {
			// we are moving to left subtree and so k - numNodes on right subtree - 1(for the parent)
			return findKthLargest(r.left, k - numNodes(r.right) - 1);
		} else {
			return findKthLargest(r.right, k);
		}
	}
	
	public int numNodes(Node r) {
		if(r == null) {
			return 0;
		}
		
		return numNodes(r.left) + numNodes(r.right) + 1;
	}
	
	public int findKthSmallest(Node r, int k) {
		if(r == null) {
			return -1;
		}
		
		if(k > numNodes(r)) {
			return -1;
		}
		
		if(numNodes(r.left) + 1 == k) {
			return r.val;
		} else if(k > numNodes(r.left) + 1) {
			return findKthSmallest(r.right, k - numNodes(r.left) - 1);
		} else {
			return findKthSmallest(r.left, k);
		}
	}
	
	public boolean find(Node r, int key) {
		if(r == null) {
			return false;
		}
		
		if(key == r.val) {
			return true;
		} else if(key > r.val){
			return find(r.right, key);
		} else {
			return find(r.left, key);
		}
	}
}
