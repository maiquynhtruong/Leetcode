public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        if (root.left == null) res.add(root.val);
        else {
            TreeNode cur = root.left;
            while (cur.next != null) {res.add(cur.val); cur = cur.next;}
        }
        findLeaves(res, root);
        addRightBoundary(res, root);
    }
    public void findLeaves(List<Integer> res, TreeNode root) {
        if (root.left == null && root.right == null) res.add(root.val);
        if (root.left != null) findLeaves(res, root.left);
        if (root.right != null) findLeaves(res, root.right);
    }
    public void addRightBoundary(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.right != null) addRightBoundary(res, root.right);
        res.add(root.val);
    }
}
