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
 */
public class Solution {
    public void convertBSTtoGT(TreeNode root, int passedDown) {
        if (root == null) return;
        convertBSTtoGT(root.right, 0);
        root.val = root.val + passedDown;
        if (root.right != null) root.val += root.right.val;
        convertBSTtoGT(root.left, root.val);
    }
    public TreeNode convertBST(TreeNode root) {
        convertBSTtoGT(root);
        return root;
    }
}
