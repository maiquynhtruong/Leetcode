// This one is wrong though
public class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % 4 != 0) {
            return false;
        } else {
            Arrays.sort(nums);
            int part = sum / 4;
            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[i] > part) {
                    return false;
                }
            }
        }
        return true;
    }
}
