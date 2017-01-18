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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        pathSum(root, sum, new LinkedList<Integer>(), lists);
        return lists;
    }
    
    public void pathSum(TreeNode root, int sum, LinkedList<Integer> l, List<List<Integer>> lists) {
        if (root == null) return;
        l.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
                lists.add(new LinkedList(l));
                l.remove(l.size()-1);
                return;
        } else {
            pathSum(root.left, sum - root.val, l, lists);
            pathSum(root.right, sum - root.val, l, lists);
        }
        l.remove(l.size()-1);
    }
}
