public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCon = 0, curCon = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) curCon++;
            else {maxCon = Math.max(curCon, maxCon); curCon = 0;}
        }
        return Math.max(maxCon, curCon);
        
    }
}
