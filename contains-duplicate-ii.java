public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], i);
            } else {
                if (Math.abs(hm.get(nums[i]) - i) <= k) {
                        return true;
                }
                hm.put(nums[i], i);
            }
        }
        return false;
    }
}
