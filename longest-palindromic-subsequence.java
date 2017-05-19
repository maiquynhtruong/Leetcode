public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.size();
        int dp[][] = new int[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i-1][j-1] + 2;
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1]);
                }
            }
        return dp[0][len];
    }
}
