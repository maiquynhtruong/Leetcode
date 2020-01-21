class Solution {
    public void moveZeroes(int[] nums) {
        int zeros = 0, counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[counter++] = nums[i];
            } else {
                zeros++;
            }
        }
        for (; counter < nums.length; counter++) {
            nums[counter] = 0;
        }
    }
}
