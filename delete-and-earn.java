class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> numCnt = new HashMap<Integer, Integer>();
        int maxSum = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            numCnt.putIfAbsent(nums[i], numCnt.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int newSum = sum - nums[i];
            newSum = newSum - numCnt.getOrDefault(nums[i]-1, 0) * (nums[i]-1) - numCnt.getOrDefault(nums[i]+1, 0) * (nums[i]+1);
            maxSum = Math.max(newSum, maxSum);
        }
        return maxSum;
    }
}
