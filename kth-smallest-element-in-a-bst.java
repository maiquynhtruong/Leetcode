class IntClass {
    int val = 0;
    public IntClass(int val) { this.val = val;}
}
class Solution {
    int kthMin = -1;
    public int kthSmallest(TreeNode root, int k) {
        IntClass kth = new IntClass(k);
        findkth(root, kth);
        return kthMin;
    }
    
    public void findkth(TreeNode root, IntClass kth) {
        if (root == null || kth.val == 0) return;
        
        findkth(root.left, kth);
        kth.val = kth.val-1;
        if (kth.val == 0) kthMin = root.val;
        findkth(root.right, kth);
    }
}
