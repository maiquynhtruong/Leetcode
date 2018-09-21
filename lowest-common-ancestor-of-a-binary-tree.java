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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q), right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null? right : left;
    }
    
}

/*** brute force way, but still pass **/

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (checkNode(root.left, p) && checkNode(root.left, q)) {
                root = root.left;
            } else if (checkNode(root.right, p) && checkNode(root.right, q)) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
    
    public boolean checkNode(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return checkNode(root.left, p) || checkNode(root.right, p);
    }
}
