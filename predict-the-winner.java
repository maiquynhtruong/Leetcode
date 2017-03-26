// 1, 5, 233, 7, 2, 67

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int player = 1;
        int n = nums.length;
        return predict(nums, 1, n-1, nums[left], 0) || predict(nums, 0, n-2, nums[n-1], 0);
    }
    
    public boolean predict(int[] nums, int left, int right, int cur1, int cur2) {
        if (left == right) {
            if (nums[left] + cur1 >= cur2) return true; 
            else return false;
        } 
        if (left == right - 1) {
            if (Math.max(nums[left], nums[right]) + cur2 <= Math.min(nums[left], nums[right]) + cur1) return true;
            else return false;
        }
        return predict(nums, left+1, right, cur1+nums[left], cur2) || predict(nums, left, right-1, cur1+nums[right], cur2);
    }
}
