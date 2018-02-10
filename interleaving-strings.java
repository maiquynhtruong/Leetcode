class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        int[][] memo = new int[n1][n2];
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++) 
                memo[i][j] = -1;
        return tryPath(s1, 0, s2, 0, s3, 0, memo);
    }
    
    public boolean tryPath(String s1, int n1, String s2, int n2, String s3, int n3, int[][] memo) {
        if (n1 == s1.length()) return s2.substring(n2).equals(s3.substring(n3));
        if (n2 == s2.length()) return s1.substring(n1).equals(s3.substring(n3));
        if (memo[n1][n2] >= 0) 
            return memo[n1][n2] == 1 ? true : false;
        boolean ans = false;
        if (s3.charAt(n3) == s1.charAt(n1) && tryPath(s1, n1+1, s2, n2, s3, n3+1, memo) ||
            s3.charAt(n3) == s2.charAt(n2) && tryPath(s1, n1, s2, n2+1, s3, n3+1, memo)) 
            ans = true;
        memo[n1][n2] = ans ? 1 : 0;
        return ans;
    }
}
