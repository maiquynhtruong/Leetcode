class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        int[][] memo = new int[n1][n2];
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++) 
                memo[i][j] = -1;
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n2; j++) {
                    int k = i + j - 1;
                    if (i == 0 && j == 0) {
                        memo[i][j] = true;
                    } else if (i == 0) {
                        memo[i][j] = memo[i][j-1] && s2.charAt(j-1) == s3.charAt(k);
                    } else if (j == 0) {
                        memo[i][j] = memo[i-1][j] && s1.charAt(i-1) == s3.charAt(k);
                    } else {
                        if (s1.charAt(i-1) == s3.charAt(k)) memo[i][j] = memo[i-1][j];
                        if (s2.charAt(j-1) == s3.charAt(k)) memo[i][j] == memo[i][j-1];       
                    }
                }
            }
        return memo[n1][n2];
    }
}
