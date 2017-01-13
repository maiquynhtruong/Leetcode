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
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) hs.remove(nums[i-k-1]);
            if (!hs.add(nums[i])) return true;
        }
        
        return false;
    }
}
