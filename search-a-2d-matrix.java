class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            int i = mid / n, j = mid % n;
            if (target > matrix[i][j]) {
                start = mid+1;
            } else if (target < matrix[i][j]) {
                end = mid;
            } else {
                return true;
            }
        }
        return matrix[end/n][end%n] == target;
    }
}
