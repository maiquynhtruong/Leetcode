public class Solution {
    public int countBattleships(char[][] board) {
         int total = 0;
         for (int i = 0; i < board.length; i++) 
             for (int j = 0; j < board[0].length; j++) 
                 if (board[i][j] == 'X') {
                    //  System.out.println("i= " + i + ", j= " + j);
                     if ((j == board[0].length-1 && (j == 0 || board[i][j-1] == '.')) || (j == 0 && (j == board[0].length-1 || board[i][j+1] == '.')) || (j >= 0 && j < board[0].length-1 && board[i][j+1] == '.' && board[i][j-1] == '.')) {
                         System.out.println("1");
                         if (i == 0 || board[i-1][j] == '.') total++;
                     } else {
                         System.out.println("2");
                         if (j == 0 || board[i][j-1] == '.') total++;
                     }
                 }
         return total;
    }
}
