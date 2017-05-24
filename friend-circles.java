/****************************************Union find solution***************************************/
public class Solution {
    int[] parent = new int[];
    int count;
    public int findCircleNum(int[][] M) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        count = M.length;
        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) union(i, j);
            }
        return count;
    }
    
    public void union(int i, int j) {
        int root_i = find(i);
        int root_j= find(j;
        if (root_i == root_j) return;
        parent[root_i] = parent[root_j];
        count--; // still don't get this one
    }
    public int find(int i) {
        while (i != parents[i]) {
            parent[i = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
                   
                   /********************DFS solution***************************/

public class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(M, visited, i);
            }
        }
        return count;
    }
    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] && !visited[j]) {
                dfs(M, visited, j);
            }
        }
    }
}
