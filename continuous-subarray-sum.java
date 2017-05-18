public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r += nums[i];
            r %= k;
            if (hm.containsKey(r) && hm.get(r) - i > 1) return true;
            else hm.put(r, i);
        }
        return false;
    }
}
