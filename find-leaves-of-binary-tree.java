/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class TreeNode {
		int val;
		TreeNode left = null, right = null;
		TreeNode(int value) {this.val = value;}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		while (root != null) {
			// more preferred way to create a stack
			Deque<Integer> stack = new ArrayDeque<Integer>();
			helper(root, root.left, stack);
			helper(root, root.right, stack);
			if (stack.isEmpty()) {
				stack.addFirst(root.val);
				System.out.println(Arrays.toString(stack.toArray()));
				root = null;
			} else {
				System.out.println(Arrays.toString(stack.toArray()));
			}
			
		}
	}
	
	public static void helper(TreeNode rootOfRoot,TreeNode root, Deque<Integer> stack) {
		if (root == null) return;
		else if (root.left == null && root.right == null) {
			System.out.println("root.val= " + root.val);
			stack.addFirst(root.val);
			if (root == rootOfRoot.left) rootOfRoot.left = null;
			else rootOfRoot.right = null;
			return;
		} else {
			helper(root, root.left, stack);
			helper(root, root.right, stack);
		}
	}
}
