package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.osu.cse.trees.BinarySearchTree;

public class TestBinaryTree {

	@Test
	public void testBT() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addValues(8,3,10,1,6,14,4,7,13,9);
		bst.levelOrderPrinting(bst.root, bst.getDepth(bst.root) + 1);
		assertEquals(4, bst.getDepth(bst.root));
		assertEquals(2, bst.getMinDepthBFS(bst.root));
		assertEquals(true, bst.isBalanced(bst.root));
		assertEquals(true, bst.isBalanced2(bst.root));
		
		bst = new BinarySearchTree();
		bst.addValues(38,13,51,10,12,40,84,25,89,37,66,95);
		bst.levelOrderPrinting(bst.root, bst.getDepth(bst.root) + 1);
		assertEquals(5, bst.getDepth(bst.root));
		assertEquals(2, bst.getMinDepth(bst.root));
		assertEquals(2, bst.getMinDepthBFS(bst.root));
		assertEquals(false, bst.isBalanced(bst.root));
		assertEquals(false, bst.isBalanced2(bst.root));
		
		System.out.print("\nInorder: ");
		bst.inorder(bst.root);
		System.out.print("\nPreorder: ");
		bst.preorder(bst.root);
		System.out.print("\nPostorder: ");
		bst.postorder(bst.root);
		
		System.out.println("\n\nAll paths from root to leaves..");
		bst.printAllPaths(bst.root);
		
		System.out.println("\nisBST? " + bst.isBST(bst.root));
		System.out.println("isBST? " + bst.isBST2(bst.root));
		
		int n = 7;
		System.out.println("\n" + n + "th largest element is " + bst.findKthLargest(bst.root, n));
		assertEquals(bst.findKthSmallest(bst.root, 6), bst.findKthLargest(bst.root, 7));
		assertEquals(bst.findKthSmallest(bst.root, 7), bst.findKthLargest(bst.root, 6));
		assertEquals(bst.findKthSmallest(bst.root, 3), bst.findKthLargest(bst.root, 10));
		assertEquals(bst.findKthSmallest(bst.root, 10), bst.findKthLargest(bst.root, 3));
		assertEquals(bst.findKthSmallest(bst.root, 12), bst.findKthLargest(bst.root, 1));
		assertEquals(bst.findKthSmallest(bst.root, 1), bst.findKthLargest(bst.root, 12));
		
		assertEquals(false, bst.find(bst.root, 100));
		assertEquals(false, bst.find(bst.root, 0));
		assertEquals(true, bst.find(bst.root, 38));
		assertEquals(true, bst.find(bst.root, 89));
	}
}
