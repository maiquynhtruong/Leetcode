public class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	s.add(nums[i]);
        	if (s.size() > 3) {
        		s.pollFirst();
        	}
        }
        if (s.size() < 3) return s.last();
        else return s.first();
    }
}
