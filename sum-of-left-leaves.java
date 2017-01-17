import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(sumOfLeftLeaves(root));
	}
	
	/**
	 *  
	1
   / \
  2   3
 / \
4   5
	 * */
	// Recursive
	public static int sumOfLeftLeaves(TreeNode root) {
		// System.out.println("root= " + root.val);
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				sum = root.left.val;
			} else {
				sum = sumOfLeftLeaves(root.left);
			}
		}
		if (root.right != null) {
			sum += sumOfLeftLeaves(root.right);
		}
		return sum;
	}
	
	// Iterative
	public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
    	int ans = 0;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	while (!s.empty()) {
    		root = s.pop();
    		if (root.left != null) {
    			if (root.left.left == null && root.left.right == null) {
    				ans += root.left.val;
    			} else {
    				s.push(root.left);
    			}
    		}
			if (root.right != null) {
				if (root.right.left != null || root.right.right != null) {
					s.push(root.right);
				}
			}
    	}
    	return ans;
    	
    }
}
