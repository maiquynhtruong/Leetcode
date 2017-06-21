public class Solution {
    
    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0] = g[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j-1]*g[i-j];   
            }
        }
        return g[n];
    }
}

/**


    1       2
     \     /
      2   1
      
      
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   
     4         4     4      4      4
    /         /     /      /      /
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
    
    
     
   1         3      3      2      1
    \       / \    / \    / \      \
     3     2   4  1   4  1   3      2
    / \   /        \          \      \
   2   4 1          2          4      3
                                       \
                                        4
