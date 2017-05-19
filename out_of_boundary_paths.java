public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int dp[][][] = new int[51][50][50];
        for (int ni = 0; ni <= N; i++) 
            for (int ii = 0; ii < m; ni++)
                 for (int ji = 0; ji < n; ji++) {
                    dp[ni][ii][ji] = ((ii == 0 ? 1 : dp[ni-1][ii-1][ji]) + (ii == m ? 1 : dp[ni-1][ii+1][ji]) + 
                                      (ji == 0 ? 1 : dp[ni-1][ii][ji-1] + (ji == n ? 1 : dp[ni-1][ii][ji+1]));
                 }
        return dp[N][i][j];
    }
}
