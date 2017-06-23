public class Solution {
    public int maxSubArray(int[] nums) {
        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
            for (int j = 0; j < i; j++) {
                max = Math.max(max, nums[i] - nums[j]);
            }
        }
        return max;
    }
}
