public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int numPath = 0;
    }
    public void countWays(int m, int n, int N, int times, int i, int j) {
        if (times > N) return 0;
        if (!okToGo(m, n, i, j)) {
            numPath++;
            return;
        }
        countWays(m, n, N, times+1, i-1, j);
        countWays(m, n, N, times+1, i+1, j);
        countWays(m, n, N, times+1, i, j-1);
        countWays(m, n, N, times+1, i, j+1);
        
    }
    public boolean okToGo(int m, int n, int i, int j) {
        if (i > -1 && i < m && j > -1 && j < n) return true;
        else return false;
    }
}
