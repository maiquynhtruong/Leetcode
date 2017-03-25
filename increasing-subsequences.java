public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        findSubsequencesHelper(nums, ans, temp, 0);
        return new ArrayList(ans);
    }
    public void findSubsequencesHelper(int[] nums, Set<List<Integer>> ans, List<Integer> temp, int index) {
        if (temp.size() >= 2) ans.add(new ArrayList(temp));
        for (int i = index; i < nums.length; i++) {
            if (temp.size() == 0 || temp.get(temp.size()-1) <= nums[i]) {
                 temp.add(nums[i]);
                 findSubsequencesHelper(nums, ans, temp, index+1);
                 temp.remove(temp.size()-1);
            }
        }
    }
}
