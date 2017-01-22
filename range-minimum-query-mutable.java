public class NumArray {
    int[] nums;
    int[] tree;
    int n, t;
    public NumArray(int[] num) {
        this.nums = num;
        this.tree = new int[nums.length*2];
        n = nums.length;
        t = tree.length;
        build(0, 0, n-1);
        for (int i = 0; i < t; i++) System.out.println(tree[i]);
    }
    
    public void build(int node, int left, int right) {
        // System.out.println("node= " + node + ", tree= " + tree[node] + ", left= " + left + ", right= " + right + ", nums= " + nums[left]);
        if (left == right) {
            tree[node] = nums[left];
        } else {
            int mid = (left + right) / 2; // (0+2)/2 = 1
            build(2*node+1, left, mid); // 1, 0, 1; 
            build(2*node+2, mid+1, right); // 2, 2, 2;
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }
    /**
node= 0, tree= 0, left= 0, right= 2, nums= 1
node= 1, tree= 0, left= 0, right= 1, nums= 1
node= 3, tree= 0, left= 0, right= 0, nums= 1
node= 4, tree= 0, left= 1, right= 1, nums= 3
node= 2, tree= 0, left= 2, right= 2, nums= 5

**/
    public void update(int i, int val) {
        update(0, i, val, 0, n-1);
    }
    
    public void update(int node, int i, int val, int left, int right) {
        System.out.println("node= " + node + ", left= " + left + ", right= " + right);
        if (left == right) {
            tree[node] += val - nums[i];
            nums[i] = val;
        } else {
            int mid = (left + right) / 2;
            if (left <= i && i <= mid) {
                update(2*node+1, i, val, left, mid);
            } else {
                update(2*node+2, i, val, mid + 1, right);
            }
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(i, j, 0, 0, t-1);
    }
    
    public int sumRange(int i, int j, int node, int left, int right) {
        if (left > j || right < i) {
            return 0;
        } else if (left >= i && right <= j) {
            return tree[node];
        } else {
            int mid = (left + right) / 2;
            return sumRange(i, j, 2*node+1, left, mid) + sumRange(i, j, 2*node+2, mid+1, right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
