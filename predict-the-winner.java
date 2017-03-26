public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int player = 1;
        int n = nums.length;
        return predict(nums, 1, n-1, nums[0], 0, 1) || predict(nums, 0, n-2, nums[n-1], 0, 1);
    }
    
    public boolean predict(int[] nums, int left, int right, int cur1, int cur2, int player) {
        if (player == 1) {
            if (left == right) {
                if (nums[left] + cur1 >= cur2) return true; 
                else return false;
            } 
            if (left == right - 1) {
                if (Math.max(nums[left], nums[right]) + cur2 <= Math.min(nums[left], nums[right]) + cur1) return true;
                else return false;
            }
            return predict(nums, left+1, right, cur1+nums[left], cur2, 2) || predict(nums, left, right-1, cur1+nums[right], cur2, 2);
        } else {
            if (left == right) {
                if (nums[left] + cur2 >= cur1) return true; 
                else return false;
            } 
            if (left == right - 1) {
                if (Math.max(nums[left], nums[right]) + cur1 <= Math.min(nums[left], nums[right]) + cur2) return true;
                else return false;
            }
            return predict(nums, left+1, right, cur1, nums[left] + cur2, 1) || predict(nums, left, right-1, cur1, nums[right] + cur2, 1);
        }
    }
}
