public class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        int n = nums.length;
        for (int i = 0; i < n && i <= reach; i++) {
            reach = Math.max(i + nums[i], reach);
        }
        return reach >= nums[n-1]; // or i == n;
    }
}
