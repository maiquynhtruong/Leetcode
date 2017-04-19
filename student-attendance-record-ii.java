public class Solution {
    public int checkRecord(int n) {
        // dp[i][a][l] = number of valid sequence with length i, at most a absences and at most l lates
        int[][][] dp = new int[n+1][2][3];
        dp[0] = {{1,1,1}, {1,1,1}}; // 0 length, everything is 1
        for (int i = 1; i <= n; i++) 
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int value = dp[i-1][j][k]; // P for present
                    if (j > 0) value = (value + dp[i-1][j-1][2]) % Integer.MAX_VAL;
                    if (k > 0) value = (value + dp[i-1][1][k-1]) % Integer.MAX_VAL;
                }
        return dp[n][1][2];
    }
}
