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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /**
         *           1
         *     5           10
         *  3     4      8     9
         * 2 6  7  11  12 13 14 15
         * inorder: 2, 3, 6, 5, 7, 4, 11, 1, 12, 8, 13, 10, 14, 9, 15
         * postorder:2, 6, 3, 7, 11, 4, 5, 12, 13, 8, 14, 15, 9, 10, 1
         **/
         HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
         for (int i = 0; i < inorder.length; i++) hm.put(inorder[i], i);
         TreeNode root = buildHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, hm);
         return root;
         
    }
    public TreeNode buildHelper(int[] inorder, int[] postorder, int is, int ie, int ps, int pe, HashMap<Integer, Integer> hm) {
        if (is > ie || ps > pe) {
            return null;
        } else {
            TreeNode root = new TreeNode(postorder[pe]);
            int index = hm.get(postorder[pe]);
            root.left = buildHelper(inorder, postorder, is, index-1, ps, ps + (index - is) - 1, hm);
            root.right = buildHelper(inorder, postorder, index+1, ie, ps + (index - is), pe, hm);
            return root;
        }
    }
}
