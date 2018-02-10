class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) maxNum = Math.max(maxNum, nums[i]);
        int[] points = new int[maxNum+1];
        int[] earn = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            points[nums[i]] += nums[i];
        }
        earn[0] = points[0]; earn[1] = Math.max(points[0], points[1]);
        for (int i = 1; i < points.length; i++) {
            earn[i] = Math.max(nums[i] + earn[i-2], earn[i-1]);
        }
        return Math.max(earn[points.length-1], earn[points.length-2]);
    }
}
