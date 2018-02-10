class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] robbed = new int[n];
        robbed[0] = nums[0]; robbed[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            robbed[i] = Math.max(nums[i] + robbed[i-2], robbed[i-1]);
            //robbed[i] = Math.max(robbed[i], robbed[i-1] + robbed[i+1]);    
        }
        return Math.max(robbed[n-1], robbed[n-2]);
    }
}
