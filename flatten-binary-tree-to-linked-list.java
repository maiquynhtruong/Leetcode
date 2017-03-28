/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode res = new TreeNode(0);
        flattener(root, res);
        root = res.right;
    }
    public void flattener(TreeNode root, TreeNode res) {
        if (root == null) return;
        res.right = root;
        if (root.left != null) flattener(root.left, res);
        if (root.right != null) flattener(root.right, res);
    }
}
