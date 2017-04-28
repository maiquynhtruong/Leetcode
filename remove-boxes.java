public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n+1][n+1][n+1];
        
        for (int l = 0; l < n+1; l++)
            for (int r = 0; k < n+1; k++)
                for (int i = l; i <= r; i++) {
                    if (boxes[i] == boxes[r])
                    dp[l][r][k] = Math.max(dp[l][r][k], dp[l][i][k+1] + dp[i+1][r][0]);
                }
        return dp[0][n-1][0];
    }
    
}
