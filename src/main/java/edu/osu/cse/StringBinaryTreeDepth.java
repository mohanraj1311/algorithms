package edu.osu.cse;

import java.util.Stack;

/**
 * Consider this string representation for binary trees. Each node is of the form (lr), where l represents the left child and r represents the right child. If l is the character 0, then there is no left child. Similarly, if r is the character 0, then there is no right child. Otherwise, the child can be a node of the form (lr), and the representation continues recursively. 
For example: (00) is a tree that consists of one node. ((00)0) is a two-node tree in which the root has a left child, and the left child is a leaf. And ((00)(00)) is a three-node tree, with a root, a left and a right child. 

Write a function that takes as input such a string, and returns -1 if the string is malformed, and the depth of the tree if the string is well-formed. 

For instance: 

find_depth('(00)') -> 0 
find_depth('((00)0)') -> 1 
find_depth('((00)(00))') -> 1 
find_depth('((00)(0(00)))') -> 2 
find_depth('((00)(0(0(00))))') -> 3 
find_depth('x') -> -1 
find_depth('0') -> -1 
find_depth('()') -> -1 
find_depth('(0)') -> -1 
find_depth('(00)x') -> -1 
find_depth('(0p)') -> -1
 * @author pjayachandran
 *
 */
public class StringBinaryTreeDepth {

	public static int getTreeDepth(String inp) {
		if(inp == null) {
			return -1;
		}
		
		if(inp.length() < 4) {
			return -1;
		}
		
		if(inp.charAt(0) != '(' || inp.charAt(inp.length() -1) != ')') {
			return -1;
		}
		
		int depth = -1;
		int zeroCount = 0;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<inp.length(); i++) {
			char c = inp.charAt(i);
			if(c == '(') {
				stack.push(c);
				if(stack.size() > depth) {
					depth = stack.size();
				}
				zeroCount = 0;
			} else if(c == ')') {
				stack.pop();
				zeroCount = 0;
			} else {
				if( c != '0') {
					return -1;
				} else {
					zeroCount += 1;
					if(zeroCount > 2) {
						return -1;
					}
				}
			}
		}
		
		// invalid pattern
		if(stack.size() > 0) {
			return -1;
		}
		
		return depth-1;
	}
}
