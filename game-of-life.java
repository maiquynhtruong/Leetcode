public class Solution {
    
    public void gameOfLife(int[][] board) {
		int[][] board2 = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			int[] temp = board[i];
			System.arraycopy(board[i], 0, board2[i], 0, board[i].length);	
		}
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
        		// int i = 1, j = 1;
				int n = aliveNeighbors(board2, i, j); 
                // System.out.print("n= " + n + " ");
                if (board[i][j] == 1) {
                    if (n < 2 || n > 3) board[i][j] = 0;
                } else {
                    if (n == 3) board[i][j] = 1;
                }
            }
        // System.out.println();
        }
    }
    public int aliveNeighbors(int[][] board2, int x, int y) {
  //  	System.out.println("x= " + x + ", y= " + y);
  //  	for (int i = 0; i < board2.length; i++) {
  //          for (int j = 0; j < board2[0].length; j++) 
  //          	System.out.print(board2[i][j] + " ");
  //          System.out.println();
		// }
		// System.out.println();
        int retVal = 0;
        if (x - 1 >= 0 && y - 1 >= 0) retVal += board2[x-1][y-1];
        if (x - 1 >= 0 && y >= 0) retVal += board2[x-1][y];
        if (x - 1 >= 0 && y + 1 < board2[0].length) retVal += board2[x-1][y+1];
        if (x >= 0 && y - 1 >= 0) retVal += board2[x][y-1];
        if (x < board2.length && y + 1 < board2[0].length) retVal += board2[x][y+1];
        if (x + 1 < board2.length && y - 1 >= 0) retVal += board2[x+1][y-1];
        if (x + 1 < board2.length && y >= 0) retVal += board2[x+1][y];
        if (x + 1 < board2.length && y + 1 < board2[0].length) retVal += board2[x+1][y+1];
        // System.out.print("r= " + retVal + " " );
        return retVal;
    }
}
