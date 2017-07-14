public class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    count++;
                    start = nums[start];
                    visited[start] = true;
                } while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
    }
    public static void main(String args[]) {
        
    }
}
