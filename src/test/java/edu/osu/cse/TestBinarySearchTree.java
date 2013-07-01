package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.osu.cse.trees.BinarySearchTree;
import edu.osu.cse.trees.BinarySearchTree.Node;

public class TestBinarySearchTree {

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
		System.out.println("isBST2? " + bst.isBST2(bst.root));
		System.out.println("isBST3? " + bst.isBST3(bst.root));
		
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
		
		Node root = bst.createMinimalBST(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
		assertEquals(4, bst.getDepth(root));
		assertEquals(true, bst.isBalanced(root));
		assertEquals(true, bst.isBalanced2(root));
		
		
		bst = new BinarySearchTree();
		bst.addValues(6,3,2,1,4,5,7,8,9,10,-2);
		System.out.print("All paths that add up to 10: ");
		bst.printAllPathAddUptoSum(bst.root, 10);
		System.out.print("All paths that add up to 13: ");
		bst.printAllPathAddUptoSum(bst.root, 13);
		System.out.print("All paths that add up to 18: ");
		bst.printAllPathAddUptoSum(bst.root, 18);
	}
	
	@Test
	public void testSuccessors() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addValues(6,3,2,1,4,5,7,8,9,10);
		System.out.print("\nPreorder: ");
		bst.preorder(bst.root);
		System.out.println();
		assertEquals(3, bst.preorderSuccessor(bst.find2(bst.root, 6)));
		assertEquals(2, bst.preorderSuccessor(bst.find2(bst.root, 3)));
		assertEquals(1, bst.preorderSuccessor(bst.find2(bst.root, 2)));
		assertEquals(4, bst.preorderSuccessor(bst.find2(bst.root, 1)));
		assertEquals(5, bst.preorderSuccessor(bst.find2(bst.root, 4)));
		assertEquals(7, bst.preorderSuccessor(bst.find2(bst.root, 5)));
		assertEquals(8, bst.preorderSuccessor(bst.find2(bst.root, 7)));
		assertEquals(9, bst.preorderSuccessor(bst.find2(bst.root, 8)));
		assertEquals(10, bst.preorderSuccessor(bst.find2(bst.root, 9)));
		assertEquals(-1, bst.preorderSuccessor(bst.find2(bst.root, 10)));
		
		System.out.print("Inorder: ");
		bst.inorder(bst.root);
		System.out.println();
		
		assertEquals(2, bst.inorderSuccessor(bst.find2(bst.root, 1)));
		assertEquals(3, bst.inorderSuccessor(bst.find2(bst.root, 2)));
		assertEquals(4, bst.inorderSuccessor(bst.find2(bst.root, 3)));
		assertEquals(5, bst.inorderSuccessor(bst.find2(bst.root, 4)));
		assertEquals(6, bst.inorderSuccessor(bst.find2(bst.root, 5)));
		assertEquals(7, bst.inorderSuccessor(bst.find2(bst.root, 6)));
		assertEquals(8, bst.inorderSuccessor(bst.find2(bst.root, 7)));
		assertEquals(9, bst.inorderSuccessor(bst.find2(bst.root, 8)));
		assertEquals(10, bst.inorderSuccessor(bst.find2(bst.root, 9)));
		assertEquals(-1, bst.inorderSuccessor(bst.find2(bst.root, 10)));
		
		System.out.print("Postorder: ");
		bst.postorder(bst.root);
		System.out.println();
		
		assertEquals(2, bst.postorderSuccessor(bst.find2(bst.root, 1)));
		assertEquals(5, bst.postorderSuccessor(bst.find2(bst.root, 2)));
		assertEquals(4, bst.postorderSuccessor(bst.find2(bst.root, 5)));
		assertEquals(3, bst.postorderSuccessor(bst.find2(bst.root, 4)));
		assertEquals(10, bst.postorderSuccessor(bst.find2(bst.root, 3)));
		assertEquals(9, bst.postorderSuccessor(bst.find2(bst.root, 10)));
		assertEquals(8, bst.postorderSuccessor(bst.find2(bst.root, 9)));
		assertEquals(7, bst.postorderSuccessor(bst.find2(bst.root, 8)));
		assertEquals(6, bst.postorderSuccessor(bst.find2(bst.root, 7)));
		assertEquals(-1, bst.postorderSuccessor(bst.find2(bst.root, 6)));
	}
	
	@Test
	public void testAncestors() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addValues(6,3,2,1,4,5,7,8,9,10);
		
		assertEquals(-1, bst.commonAncestor(bst.root, bst.find2(bst.root, 1), bst.find2(bst.root, 100)));
		assertEquals(3, bst.commonAncestor(bst.root, bst.find2(bst.root, 1), bst.find2(bst.root, 5)));
		assertEquals(3, bst.commonAncestor(bst.root, bst.find2(bst.root, 2), bst.find2(bst.root, 4)));
		assertEquals(6, bst.commonAncestor(bst.root, bst.find2(bst.root, 3), bst.find2(bst.root, 7)));
		assertEquals(6, bst.commonAncestor(bst.root, bst.find2(bst.root, 2), bst.find2(bst.root, 7)));
		assertEquals(6, bst.commonAncestor(bst.root, bst.find2(bst.root, 1), bst.find2(bst.root, 7)));
		assertEquals(6, bst.commonAncestor(bst.root, bst.find2(bst.root, 4), bst.find2(bst.root, 7)));
		assertEquals(6, bst.commonAncestor(bst.root, bst.find2(bst.root, 5), bst.find2(bst.root, 7)));
		assertEquals(6, bst.commonAncestor(bst.root, bst.find2(bst.root, 3), bst.find2(bst.root, 10)));
		assertEquals(6, bst.commonAncestor(bst.root, bst.find2(bst.root, 10), bst.find2(bst.root, 3)));
	}
}
