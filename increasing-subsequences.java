public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int len = 2; len <= n - i; len++) {
                int pivot = 1, int index = i;
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[index++]);
                while (index < n && pivot < len) {
                    if (nums[index] > nums[index-1]) {
                        temp.add(nums[index]);
                        pivot++;
                    }
                    index++;
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
