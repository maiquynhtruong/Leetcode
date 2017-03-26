// 1, 5, 233, 7, 2, 67

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return predict(nums, 0, n-1) >= 0;
    }
    
    public int predict(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        else {
            return Math.max(nums[left] - predict(nums, left+1, right), nums[right] - predict(nums, left, right-1));
        }
    }
}
