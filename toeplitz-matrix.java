class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            int row = i, col = 0;
            while (row < m && col < n) {
                if (matrix[row][col] != matrix[i][0]) return false;
                row++; col++;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            int row = 0, col = i;
            while (row < m && col < n) {
                if (matrix[row][col] != matrix[0][i]) return false;
                row++; col++;
            }
        }
        return true;
    }
}

