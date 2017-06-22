/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }     -11
 *        /\
 *      -7  10
 *      /    \
 *     2      3
 *    / \    / \
 *   4   5  6   7
 *      /  / \   \
 *     8  13  9   12
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPath(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);
        root.val = root.val + Math.max(left, right);
        max = Math.max(max, root.val);
        return root.val;
    }
    public int maxPathSum(TreeNode root) {
        int res = maxPath(root);
        return max;
    }
}
