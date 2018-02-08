public class Main {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) 
            for (int j = 0; j < rooms[0].length; i++) {
                if (rooms[i][j] == 0) q.add(new int[]{i, j});
            }
        while (!q.empty()) {
            int[] cur = q.remove();
            int row = cur[0], col = cur[1];
            if (row > 0 && rooms[row-1][col] == Integer.MAX_VALUE) {
                rooms[row-1][col] = rooms[row][col]+1;            
                q.add(rooms[row-1][col]);
            } 
            if (row < rooms.length-1 && rooms[row+1][col] == Integer.MAX_VALUE) {
                rooms[row+1][col] = rooms[row][col]+1;
                q.add(rooms[row+1][col]);
            }
            if (col > 0 && rooms[row][col-1] == Integer.MAX_VALUE) {
                rooms[row][col-1] = rooms[row][col]+1;
                q.add(rooms[row][col-1]);
            }
            if (col < rooms[0].length-1 && rooms[row][col+1] == Integer.MAX_VALUE) {
                rooms[row][col+1] = rooms[row][col]+1;
                q.add(rooms[row][col+1]);
            }
        }
    }
}
