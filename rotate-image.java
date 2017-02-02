public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n-i-1; j++) {
                int temp = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        for (int i = 0; i < n; i++) System.out.println(Arrays.toString(matrix[i]));
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n; j++) {
                int temp = matrix[n-i-1][j];
                matrix[n-i-1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
    }
}
