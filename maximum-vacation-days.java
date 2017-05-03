public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        int[][] dp = new int[n][k];
        for (int src = 0; src < n; src++) {
            for (int des = 0; des < n; des++) {
                for (int week = 0; week < k; week++) {
                    if (flight[src][des]) dp[des][week] = Math.max(dp[des][week], dp[src][week-1] + days[des][week]);
                }
            }
        }
        
    }
}
    
