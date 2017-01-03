public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int n = nums.length;
        output[0] = 1; output[1] = nums[0]; 
        for (int i = 2; i < n; i++) {
        	output[i] = output[i-1] * nums[i-1];
        }
        // for (int i = 0; i < n; i++) System.out.print(output[i] + " ");
        int temp = 1;
        for (int i = n-2; i >= 0; i--) {
        	temp *= nums[i+1];
        	output[i] = output[i]*temp;
        }
        return output;
    }
}
