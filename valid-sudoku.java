class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] flips = {{0,0,0}, {0,0,0}, {0,0,0}};
        for (int i = 0; i < 9; i++) {
            int flip = 0;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if ((flip & (1 << num)) != 0) return false;
                else flip = flip | (1 << num);
            }
            flip = 0;
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                int num = board[j][i] - '0';
                if ((flip & (1 << num)) != 0) return false;
                else flip = flip | (1 << num);
            }
        
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if ((flips[i/3][j/3] & (1 << num)) != 0) return false;
                else flips[i/3][j/3] = flips[i/3][j/3] | (1 << num);
            }
        }
        return true;
    }
}
