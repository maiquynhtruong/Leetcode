public class Solution {
    public int findCircleNum(int[][] M) {
        HashSet<Integer> friendGraph = new HashSet<Integer>();
        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[0].length; j++)
                if (M[i][j] == 1 && i != j) {
                    friendGraph.add(i);
                    friendGraph.add(j);
                }
        return friendGraph.size();
    }
}
