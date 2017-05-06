public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        // int[][] dp = new int[n][k];
        // Since the values of week i only depend on the the values of week i-1, we can compress two-dimensional dp array into one dimensional
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int week = 0; week < k; week++) {
            int[] temp = new int[n];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int des = 0; des < n; des++) {
                for (int src = 0; src < n; src++) {
                    if (flight[src][des] || src == des) temp[des] = Math.max(temp[des], dp[src] + days[des][week]);
                }
            }
            dp = temp;
        }
        int max = 0;
        for (int i : dp) {
            max - Math.max(max, i);
        }
        return max;
    }
}
    
