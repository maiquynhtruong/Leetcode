public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        Set<int[]> lists = new HashSet<int[]>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (findPacific(i, j, matrix) && findAtlantic(i, j, matrix)) lists.add(new int[]{i,j});
            }
        return new ArrayList<int[]>(lists);
    }
    /**
     *          i-1,j  
     * i,j-1    i,j     i,j+1
     *          i+1,j  
     **/
    public boolean findPacific(int i, int j, int[][] matrix) {
        if (i == 0 || j == 0) return true;
        if (matrix[i][j-1] > matrix[i][j] && matrix[i-1][j] > matrix[i][j]) return false;
        else return findPacific(i, j-1, matrix) || findPacific(i-1, j, matrix);
    }
    
    public boolean findAtlantic(int i, int j, int[][] matrix) {
        if (i == matrix.length-1 || j == matrix[0].length-1) return true;
        if (matrix[i][j+1] > matrix[i][j] && matrix[i+1][j] > matrix[i][j]) return false;
        else return findAtlantic(i,j+1, matrix) || findPacific(i+1, j, matrix);
    }
}
