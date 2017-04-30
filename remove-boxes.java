public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n+1][n+1][n+1];
        int ans = dfs(boxes, dp, 0, n-1, 0);
    }
    public int dfs(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];
        while (r > 1 && boxes[r] == boxes[r-1]) {r--; k++;}
        dp[l][r][k] = dfs(boxes, dp, l, r-1, 0) + (k+1)*(k+1);
        for (int i = l; i < r; i++)
            if (boxes[i] == boxes[r]) 
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes, dp, l, i, k+1) + dfs(i+1, r, 0));
        return dp[l][r][k];
    }
    
}
