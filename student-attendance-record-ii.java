public class Solution {
    public int checkRecord(int n) {
        // dp[i][a][l] = number of valid sequence with length i, at most a absences and at most l consecutive TRAILING lates
        int[][][] dp = new int[n+1][2][3];
        dp[0] = {{1,1,1}, {1,1,1}}; // 0 length, everything is 1
        for (int i = 1; i <= n; i++) 
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int value = dp[i-1][j][2]; // P for present
                    if (j > 0) value = (value + dp[i-1][j-1][2]) % Integer.MAX_VAL; // A for absent
                    if (k > 0) value = (value + dp[i-1][j][k-1]) % Integer.MAX_VAL; // L for late
                    dp[i][j][k] = val;
                }
        return dp[n][1][2];
    }
}
