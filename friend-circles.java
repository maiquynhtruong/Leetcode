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
        count--;
    }
    public int find(int i) {
        while (i != parents[i]) {
            parent[i = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
