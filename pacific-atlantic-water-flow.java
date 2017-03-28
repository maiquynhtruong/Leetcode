public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> lists = new LinkedList<int[]>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return lists;
        int n = matrix.length; int m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) lists.add(new int[]{i,j});
            }
        return lists;
    }
    /**
     *          i-1,j  
     * i,j-1    i,j     i,j+1
     *          i+1,j  
     **/
    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length; int m = matrix[0].length;
        if (x<0 || x>=n || y<0 || y >= m || visited[x][y] || height > matrix[x][y]) return;
        visited[x][y] = true;
        dfs(matrix, visited, matrix[x][y], x-1, y);
        dfs(matrix, visited, matrix[x][y], x+1, y);
        dfs(matrix, visited, matrix[x][y], x, y-1);
        dfs(matrix, visited, matrix[x][y], x, y+1);
    }
}
