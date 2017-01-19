/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int value) {this.val = value;}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		System.out.println(countUnivalSubtrees(root));
	}
	public static int countUnivalSubtrees(TreeNode root) {
		if (root == null) return 0;
		return countUnivals(root);
	}
	public static int countUnivals(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left != null && root.right != null) {
			int left = countUnivals(root.left);
			int right = countUnivals(root.right);
			if (root.left.val == root.val && root.right.val == root.val) 
				return 1 + right + left;
			else return left + right;
		} else if (root.left != null) {
			int left = countUnivals(root.left);
			if (root.left.val == root.val)
				return left + 1;
			else return left;
		} else {
			int right = countUnivals(root.right);
			if (root.right.val == root.val)
				return right + 1;
			else return right;
		}
	}
}
