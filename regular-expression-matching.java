public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean dp[][] = new boolean[s.size()+1][p.size()+1];
        for (int i = 0; i < s.size(); i++) 
            for (int j = 0; j < p.size(); j++) {
                if (p.charAt(j) == s.charAt(i)) dp[i+1][j+1] = dp[i][j];
                if (p.charAt(i) == '.') dp[i+1][j+1] = dp[i][j]; // '.' can replace any character
                if (p.charAt(i) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) == '.') dp[i+1][j+1] = dp[i+1][j-1];
                    else {
                        dp[i+1][j+1] = dp[i+1][j-1] || dp[i][j+1] || dp[i+1][j];
                    }
                }
            }
        return dp[s.size()][p.size()];
    }
}
