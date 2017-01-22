public class NumArray {
    int[] nums;
    int[] tree;
    int n, t;
    public NumArray(int[] num) {
        this.nums = num;
        this.tree = new int[nums.length*2];
        n = nums.length;
        t = tree.length;
        build();
    }
    
    public void build() {
        for (int i = n; i < 2*n; i++) tree[i] = nums[i-n];
        for (int i = n-1; i > 0; i--) tree[i] = tree[i<<1] + tree[i<<1|1];
    }
    public void update(int i, int val) {
        for (tree[i += n] = val; i > 1; i >>= 1) tree[i>>1] = tree[i] + tree[i^1];
    }
    
    public int sumRange(int i, int j) {
        return sumRange(i, j, 0, 0, t-1);
    }
    
   public int sumRange(int i, int j) {
        int res = 0;
        for (i += n, j += n; i <= j; i >>= 1, j >>= 1) {
            if (i % 2 == 1) res += tree[i++];
            if (j % 2 == 0) res += tree[j--];
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
