class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> cuts = new HashMap<>();
        int maxCuts = 0;
        for (int row = 0; row < wall.size(); row++) {
            List<Integer> bricks = wall.get(row);
            int bSum = 0;
            for (int b = 0; b < bricks.size()-1; b++) {
                bSum += bricks.get(b);
                cuts.put(bSum, cuts.getOrDefault(bSum, 0)+1);
                maxCuts = Math.max(maxCuts, cuts.get(bSum));
            }
        }
        return wall.size()-maxCuts;   
    }
}
