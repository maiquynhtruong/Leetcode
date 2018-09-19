class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        // maxSum = Math.max(maxSum, sum);
        
        return maxSum;
    }
}

/**

[-2,1,-3,4,-1,2,1,-5,4],
  0,1, 0,4, 3,5,6, 1,5
  
  **/
