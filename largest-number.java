public class Solution {
    public String largestNumber(int[] nums) {
        Arrays.sort(nums, new Comparator() {
            public int compare(int n1, int n2) {
                String s1 = String.valueOf(n1);
                String s2 = String.valueOf(n2);
                return Integer.valueOf(s1+s2) - Integer.valueOf(s2+s1);
            }    
        });
        String res = "";
        for (int i = 0; i < nums.length; i++) res += nums[i];
        
    }
}
