public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        boolean up = true;
        int layers = Math.max(matrix.length, matrix[0].length);
        for (int l = 0; l < layers; l++) {
            if (!up) {
                int j = l-1;
                for (int i = 0; i < l; i++) 
                    System.out.println(matrix[i][j--]);
            } else {
                int i = l-1;
                for (int j = 0; j < l; j++)
                    System.out.println(matrix[i--][j]);
            }
            up = !up;
        }
    }
}
