package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.osu.cse.trees.BinarySearchTree;

public class TestBinaryTree {

	@Test
	public void testBT() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addValues(8,3,10,1,6,14,4,7,13);
		bst.levelOrderPrinting(bst.root, bst.getDepth(bst.root) + 1);
		assertEquals(3, bst.getDepth(bst.root));
		assertEquals(2, bst.getMinDepthBFS(bst.root));
		
		bst = new BinarySearchTree();
		bst.addValues(38,13,51,10,12,40,84,25,89,37,66,95);
		bst.levelOrderPrinting(bst.root, bst.getDepth(bst.root) + 1);
		assertEquals(4, bst.getDepth(bst.root));
		assertEquals(2, bst.getMinDepth(bst.root));
		assertEquals(2, bst.getMinDepthBFS(bst.root));
	}
}
