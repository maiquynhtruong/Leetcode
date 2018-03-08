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
        if (root == null) return root;  
        int curVal = root.val;
        // if ((curVal <= p.val && curVal >= q.val) || (curVal >= p.val && curVal <= q.val)) return root;  
        if (curVal < p.val && curVal < q.val) return lowestCommonAncestor(root.right, p, q);
        if (curVal > p.val && curVal > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
