// Top solution using partial sums
public class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
       for (int i = 1; i < nums.length; i++) {
           nums[i] = nums[i-1] + nums[i];
       }
       this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) return nums[j];
        return nums[j] - nums[i-1];
    }
}

// Tried implementing Segmented Tree but failed horribly
public class NumArray {

    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        tree = new int[nums.length * 2];
        this.nums = nums;
    }
    public int sumRange(int left, int right) {
        return query(left, right, 0, 0, nums.length-1);
    }
    // start and end is range represented by the node at index node
    public int query(int l, int r, int node, int start, int end) {
        if (l > end || r < start) {
            // range represented by a node is completely outside the given range
            return 0;
        } else if (l <= start && r >= end) {
            // range represented by a node is completely inside the given range
            return tree[node];
        } else {
            // range represented by a node is partially inside and partially outside the given range
            int mid = (start + end) / 2;
            int p1 = sumRange(l, r, 2*node, start, mid);
            int p2 = sumRange(l, r, 2*node+1, mid+1, end);
            return p1+p2;
        }
    }
    
    public void build(int start, int end, int node) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = (start + end) / 2;
            build(start, mid, 2*node);
            build(mid+1, end, 2*node+1);
            tree[node] = tree[2*node] + tree[2*node+1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
