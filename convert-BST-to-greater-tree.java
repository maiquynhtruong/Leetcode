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
    public void convertBST1(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root.right;
        while (cur != null) {
            convertBST1(cur);
            root.val += cur.val;
            cur = cur.left;
        }
        
    }
    public TreeNode convertBST(TreeNode root) {
        convertBST1(root);
        convertBST1(root.left);
        return root;
    }
}
