/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int value) {this.val = value;}
	}
	
	public static void main (String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(closestValue(root, 15.5));
	}
	
	static int minVal = Integer.MAX_VALUE;
	public static int closestValue(TreeNode root, double target) {
		if (root == null) {return Integer.MAX_VALUE;}
		if (root.val < target) {
			int rightVal = closestValue(root.right, target);
			if (Math.abs(rightVal - target) < Math.abs(root.val - target)) {
				return rightVal;
			} else {
				return root.val;
			}
		} else {
			int leftVal = closestValue(root.left, target);
			if (Math.abs(leftVal - target) < Math.abs(root.val - target)) {
				return leftVal;
			} else {
				return root.val;
			}
		}	
	}
	
	// Shorter
	static double minVal = Integer.MAX_VALUE;
	static int curMin = Integer.MAX_VALUE;
	public static int closestValue(TreeNode root, double target) {
		if (root == null) {return Integer.MAX_VALUE;}
		if (Math.abs(root.val - target) < minVal) {
			minVal = Math.abs(root.val - target);
			curMin = root.val;
		}
		if (root.val < target) {
			closestValue(root.right, target);
		} else {
			closestValue(root.left, target);
		}	
		return curMin;
	}
}
