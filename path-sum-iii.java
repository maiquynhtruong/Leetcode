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
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public int pathSum(TreeNode root, int sum) {
        
    }
    
    public void countPaths(TreeNode root, List<Integer> curList, int runningSum, int sum) {
        
        if (root == null) return;
        
        if (runningSum == sum) {
            lists.add(curList);
            curList = new ArrayList<Integer>();
        } else if (runningSum + root.val > sum) {
            runningSum = root.val;
            curList = new ArrayList<Integer>();
            curList.add(runningSum)
        }
         
        countPaths(root.left, curList, 0, sum);
        curList = new ArrayList<Integer>();
        countPaths(root.right, curList, 0, sum);
    
    }
}
