public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        for (int i = 0; i < s.size(); i++) 
            for (int j = 0; j < p.size(); j++) {
                if (p.charAt(j) == s.charAt(i)) dp[i][j] = dp[i-1][j-1];
                if (p.charAt(i) == '.') dp[i][j] = dp[i-1][j-1]; // '.' can replace any character
                if (p.charAt(i) == '*') {
                    if (p.charAt(j-1) != s.charAt(i)) dp[i][j] = dp[i][j-2];
                    else if (p.charAt(j-1) != s.charAt(i) || p.charAt(j-1) == '.') {
                        
                    }
                }
            }
    }
}
