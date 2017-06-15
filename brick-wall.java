public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxBricks = 0;
        for (List<Integer> row : wall) {
            int length = 0;
            for (int i : row) {
                length += i;
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return maxBricks;
    }
}
