/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
             10
            /   \
           8     13
          / \   / \
         5  9 12   15
         It is reversed inorder traversal
 */
public class Solution {
    int sum = 0;
    public TreeNode convert(TreeNode root) {
        if (root == null) return;
        convert(root.right);
        sum += cur.val;
        cur.val = sum;
        convert(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
}
