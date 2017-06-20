public class Solution {
    
    public int numTrees(int n) {
        boolean used[] = new boolean[n+1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += count(visited, 1);
        }
    }
    
    public int count(boolean[] visited, int numUsed) {
        if (numUsed == n) return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res += count(visited, i, numUsed+1);
                visited[i] = false;sni
            }
        }
        return res;
    }
    
}
