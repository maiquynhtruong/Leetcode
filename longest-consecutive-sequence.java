public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int maxNum = 0;
        for (int val : nums) {
            if (!hm.containsKey(val)) {
                int left, right;
                if (hm.containsKey(val-1)) {
                    left = hm.get(val-1);
                } else {
                    left = 0;
                }
                if (hm.containsKey(val+1)) {
                    right = hm.get(val+1);
                } else {
                    right = 0;
                }
                int curMax = left + right + 1; 
                hm.put(val, curMax);
                hm.put(val-left, curMax);
                hm.put(val+right, curMax);
                maxNum = Math.max(maxNum, curMax);
            } else {
                continue;
            }
        }
        return maxNum;
    }
}
