class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums == null || nums.length == 0) return list;
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > end+1) {
                if (start != end) {
                    list.add(start + "->" + end);
                } else {
                    list.add(String.valueOf(start));
                }
                start = nums[i];
            }
            end = nums[i];
        }
        
        if (start != end) {
            list.add(start + "->" + end);
        } else {
            list.add(String.valueOf(start));
        }
        return list;
    }
}
