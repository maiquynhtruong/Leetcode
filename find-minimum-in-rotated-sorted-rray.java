class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i-1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
