/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int counter = 0, value;
    public int kthSmallest(TreeNode root, int k) {
        findkth(root, k);
        return value;
    }
    public void findkth(TreeNode root, int k) {
        if (root.left != null) findkth(root.left, k);
        counter++;
        if (counter == k) {
            value = root.val; return;
        }
        if (root.right != null) findkth(root.right, k);
    }
}
