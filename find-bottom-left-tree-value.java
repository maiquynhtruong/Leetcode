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
    int val, maxRow = -1;
    public void traverse(TreeNode root, int level) {
        if (root == null) return;
        if (level > maxRow) {
            maxRow = level;
            val = root.val;
        }
        if (root.left != null) traverse(root.left, level+1);
        if (root.right != null) traverse(root.right, level+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 0);
        return val;
    }
}
