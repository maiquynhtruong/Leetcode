public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1, curVal = nums[0], curPos = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] != curVal) {
        		nums[curPos] = nums[i];
        		curPos++;
        		curVal = nums[i];
        	} 
        }
        return curPos;
    }
}
