class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;        
        int[] points = new int[10005], earn = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            points[nums[i]] += nums[i];
        }
        earn[0] = points[0]; earn[1] = Math.max(points[0], points[1]);
        for (int i = 2; i < 10001; i++) {
            earn[i] = Math.max(earn[i] + earn[i-2], earn[i-1]);
        }
        return earn[10000];
    }
}
