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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) return list;
        list.add("");
        binaryPaths(list, root);
        return list;
    }
    
    public void binaryPaths(List<String> list, TreeNode root) {
        if (root == null) return;
        String cur = list.remove(list.size()-1);
        // System.out.println("root.val= " + root.val + ", cur= " + cur + ", " + Arrays.toString(list.toArray()));
        if (root.left == null && root.right == null) {
            list.add(cur + String.valueOf(root.val));
            return;
        } else {
            if (root.left != null) {
                list.add(cur + String.valueOf(root.val) + "->");
                binaryPaths(list, root.left);
            }
            if (root.right != null) {
                list.add(cur + String.valueOf(root.val) + "->");
                binaryPaths(list, root.right);
            }
        }
    }
}
