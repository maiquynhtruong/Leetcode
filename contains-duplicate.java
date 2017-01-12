public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int n : nums) {
            if (hs.contains(n)) {
                return true;
            }
            hs.add(n);
        }
        return false;
    }
}
