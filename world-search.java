class Solution {

  public static  boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (!visited[i][j] && board[i][j] == word.charAt(0)) return wordExists(board, word, 0, visited, i, j); 
        }
      }      
  }
  
  public static boolean wordExists(char[][] board, String word, int iWord, boolean[][] visited, int i, int j) {
      if (iWord >= word.length()) return true;
      if (board[i][j] != word.charAt(iWord)) return false;
      visited[i][j] = true;
      boolean top = true, left = true, right = true, bottom = true;
      if (inBounds(board, i, j-1) && !visited[i][j-1]) top = wordExists(board, word, iWord+1, visited, i, j-1);
      if (inBounds(board, i-1, j) && !visited[i-1][j]) top = wordExists(board, word, iWord+1, visited, i-1, j);
      if (inBounds(board, i, j+1) && !visited[i][j+1]) top = wordExists(board, word, iWord+1, visited, i, j+1);
      if (inBounds(board, i+1, j) && !visited[i+1][j]) top = wordExists(board, word, iWord+1, visited, i+1, j);
      return top || left || right || bottom;
  }

  public static boolean inBounds(char[][] board, int row, int col) {
    return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
  }

  public static void main(String[] args) {
      char[][] board = {
                          {'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}
                       };
      String word = "ABCCED";
      System.out.println(exist(board, word));
 

}
