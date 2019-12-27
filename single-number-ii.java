class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> ones = new HashSet<Integer>();
        HashSet<Integer> twos = new HashSet<Integer>();
        HashSet<Integer> threes = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (ones.contains(nums[i])) {
                twos.add(nums[i]);
                ones.remove(nums[i]);
            } else if (twos.contains(nums[i])) {
                twos.remove(nums[i]);
                threes.add(nums[i]);
            } else {
                ones.add(nums[i]);
            }
        }
        List<Integer> list = new ArrayList<>(ones);
        return list.get(0);
    }
}
