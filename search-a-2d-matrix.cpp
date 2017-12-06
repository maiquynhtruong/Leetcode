class Solution {

public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int size = matrix.size();
        if (size == 0) return false;
        int colSz = matrix[0].size(), col = colSz-1, row = 0;
        while (row < size && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
};
