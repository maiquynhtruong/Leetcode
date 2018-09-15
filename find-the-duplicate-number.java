class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        int p1 = nums[0], p2 = nums[nums[0]];
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        }
        
        p2 = 0;
        
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        
        return p1;
    }
}
