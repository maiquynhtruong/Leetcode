public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (List<Integer> row : wall) {
            for (int i : row) {
                if (!map.containsKey(i)) map.put(i, 0);
                map.put(i, map.get(i) + 1);
            }
        }
        int maxBricks = 0;
        for (int i : map.values()) {
            if (maxBricks < i) maxBricks = i;
        }
        return maxBricks;
    }
}
