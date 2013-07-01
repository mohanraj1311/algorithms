package edu.osu.cse.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	public Node root = null;

	public static class Node {
		int val;
		Node left;
		Node right;
		Node parent;

		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
			this.parent = null;
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
		if (r == null) {
			return true;
		}

		int leftHeight = getDepth(r.left);
		int rightHeight = getDepth(r.right);
		if (Math.abs(leftHeight - rightHeight) > 1) {
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
		if (checkHeight(r) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	private int checkHeight(Node r) {
		if (r == null) {
			return 0;
		}

		int leftHeight = checkHeight(r.left);
		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = checkHeight(r.right);
		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
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
				r.left.parent = r;
			} else {
				addImpl(r.left, v);
			}
		} else {
			if (r.right == null) {
				r.right = new Node(v);
				r.right.parent = r;
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
		preorder(r.left);
		preorder(r.right);
	}

	public void postorder(Node r) {
		if (r == null) {
			return;
		}

		postorder(r.left);
		postorder(r.right);
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

	// This algorithm performs an inorder traversal, remembers the parent node
	// check the current node with that of parent to determine if the BST
	// conditions are met or not. Time complexity O(N) and space O(1).
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

	// This algorithm is same as the previous one but in this case no static
	// variable is used. The previous node is passed around as function
	// parameter.
	public boolean isBST2(Node r) {
		return isBST2Impl(r, null);
	}

	private boolean isBST2Impl(Node r, Node prev) {
		if (r == null) {
			return true;
		}

		if (r.left != null) {
			if (!isBST2Impl(r.left, r.left.left)) {
				return false;
			}
		}

		if (prev != null && prev.val > r.val) {
			return false;
		}

		return isBST2Impl(r.right, r);
	}

	// This algorithm passes around min and max values to each subtree.
	// For example: The left subtree of root should have values in the range
	// INT_MIN to root.value and the right subtree of root should have values
	// in the range root.value to INT_MAX. As we descend further down on left
	// the range should be between parents values and its grand parents value
	public boolean isBST3(Node r) {
		return isBST3Impl(r, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST3Impl(Node r, int minValue, int maxValue) {
		if (r == null) {
			return true;
		}

		if (r.val < minValue || r.val > maxValue) {
			return false;
		}

		if (!isBST3Impl(r.left, minValue, r.val)
				|| !isBST3Impl(r.right, r.val, maxValue)) {
			return false;
		}
		return true;
	}

	public int findKthLargest(Node r, int k) {
		if (r == null) {
			return -1;
		}

		if (k > numNodes(r)) {
			return -1;
		}

		if (numNodes(r.right) + 1 == k) {
			return r.val;
		} else if (k > numNodes(r.right) + 1) {
			// we are moving to left subtree and so k - numNodes on right
			// subtree - 1(for the parent)
			return findKthLargest(r.left, k - numNodes(r.right) - 1);
		} else {
			return findKthLargest(r.right, k);
		}
	}

	/**
	 * This method counts the number of nodes under a given node
	 * 
	 * @param r
	 * @return
	 */
	public int numNodes(Node r) {
		if (r == null) {
			return 0;
		}

		return numNodes(r.left) + numNodes(r.right) + 1;
	}

	public int findKthSmallest(Node r, int k) {
		if (r == null) {
			return -1;
		}

		if (k > numNodes(r)) {
			return -1;
		}

		if (numNodes(r.left) + 1 == k) {
			return r.val;
		} else if (k > numNodes(r.left) + 1) {
			return findKthSmallest(r.right, k - numNodes(r.left) - 1);
		} else {
			return findKthSmallest(r.left, k);
		}
	}

	public boolean find(Node r, int key) {
		if (r == null) {
			return false;
		}

		if (key == r.val) {
			return true;
		} else if (key > r.val) {
			return find(r.right, key);
		} else {
			return find(r.left, key);
		}
	}

	public Node find2(Node r, int key) {
		if (r == null) {
			return null;
		}

		if (key == r.val) {
			return r;
		} else if (key > r.val) {
			return find2(r.right, key);
		} else {
			return find2(r.left, key);
		}
	}

	// given a list of elements, construct a BST with minimal height.
	// Idea:
	// - Mid element will be the root of tree (and each subtree as well)
	// - Left half of the array will become left subtree and right half of the
	// array
	// becomes the right subtree
	// - Recurse
	public Node createMinimalBST(int[] inp) {
		if (inp == null) {
			return null;
		}
		return createMinimalBSTImpl(inp, 0, inp.length - 1);
	}

	private Node createMinimalBSTImpl(int[] inp, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low) / 2;
		Node root = new Node(inp[mid]);
		root.left = createMinimalBSTImpl(inp, low, mid - 1);
		root.right = createMinimalBSTImpl(inp, mid + 1, high);
		return root;
	}

	public int inorderSuccessor(Node r) {
		if (r.right == null) {
			if (r.parent == null) {
				return -1;
			}

			// r is on left subtree
			if (r.parent != null && r.parent.left == r) {
				return r.parent.val;
			} else {
				// r is on right subtree
				Node p = r.parent;
				Node q = p.parent;

				while (q != null && q.right == p) {
					p = q;
					q = q.parent;
				}

				// we are done, we have visited all nodes. r is the rightmost
				// node
				if (q == null) {
					return -1;
				}

				return q.val;
			}
		} else {
			Node leftMostChild = leftMostChildren(r.right);
			return leftMostChild.val;
		}
	}

	private Node leftMostChildren(Node r) {
		if (r == null) {
			return r;
		}

		while (r.left != null) {
			r = r.left;
		}

		return r;
	}

	public int preorderSuccessor(Node r) {
		if (r.left != null) {
			return r.left.val;
		} else {
			if (r.right != null) {
				return r.right.val;
			} else {
				// if r is in the left subtree
				if (r.parent.left == r) {
					while (r.parent.right == null) {
						r = r.parent;
					}
					return r.parent.right.val;
				} else {
					// if r is in the right subtree
					Node q = r.parent.parent;
					Node p = r.parent;

					while (q != null && q.left != p) {
						p = q;
						q = q.parent;
					}

					// r is the rightmost node and there is no pre-order
					// successor
					if (q == null) {
						return -1;
					}

					return q.right.val;
				}
			}
		}
	}

	public int postorderSuccessor(Node r) {
		// r is on the left subtree of parent
		if (r.parent != null && r.parent.right != null && r.parent.right != r) {
			// if parent's right children is not null then get the right
			// subtrees left most child in left subtree. if left child doesn't
			// exist then get right child. if the left subtree itself doesn't
			// exist then get the left child (right child if left child doesn't
			// exist) of right most subtree
			Node postOrderChild = postOrderChildren(r.parent.right);
			return postOrderChild.val;
		} else if (r.parent == null) {
			// if parent is null then we are done. in post order root node is
			// the last one whose parent is null
			return -1;
		} else {
			// r is on the right subtree of the parent

			// if parent doesn't have right child then we are done traversing
			// all
			// children and hence return parent
			return r.parent.val;
		}
	}

	private Node postOrderChildren(Node r) {
		if (r == null) {
			return null;
		}

		// if left child is null then check right for righ child
		if (r.left == null) {
			// if right child is also null then return the current node's parent
			if (r.right == null) {
				return r;
			} else {
				// descend down the right subtree
				return postOrderChildren(r.right);
			}
		} else {
			// if left subtree exists, descend down the left subtree
			return postOrderChildren(r.left);
		}
	}

	public int commonAncestor(Node r, Node p, Node q) {
		if (r == null) {
			return -1;
		}

		if(p == null || q == null) {
			return -1;
		}
		

		// if r contains both p and q is contained in either left or right subtree
		// then we should r. else if p or q exists on one side of the tree
		// then we should consider only the side which contains both p and q
		if ((contains(r.left, p) && contains(r.right, q))
				|| (contains(r.left, q) && contains(r.right, p))) {
			return r.val;
		} else {
			int leftAnc = commonAncestor(r.left, p, q);
			// left subtree contains both p and q
			if(leftAnc != -1) {
				return leftAnc;
			}
			
			int rightAnc = commonAncestor(r.right, p, q);
			// right subtree contains both p and q
			if(rightAnc != -1) {
				return rightAnc;
			}
		}

		return -1;
	}

	/**
	 * checks if the subtree r contains node p
	 * 
	 * @param r
	 * @param p
	 * @return
	 */
	private boolean contains(Node r, Node p) {
		if (r == null) {
			return false;
		}

		if (r == p) {
			return true;
		}
		
		return contains(r.left, p) || contains(r.right, p);
	}
	
	public void printAllPathAddUptoSum(Node r, int sum) {
		if(r == null) {
			return;
		}
		
		printAllPathAddUptoSumImpl(r, sum, "");
	}

	private void printAllPathAddUptoSumImpl(Node r, int sum, String path) {
		
		if(r == null) {
			return;
		}
		path = path + "/" + r.val;
		if(sum - r.val == 0) {
			System.out.println(path);
		}
		
		printAllPathAddUptoSumImpl(r.left, sum - r.val, path);
		printAllPathAddUptoSumImpl(r.right, sum - r.val, path);
	}
}
