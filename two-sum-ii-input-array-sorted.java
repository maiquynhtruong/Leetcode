class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] indices = new int[2];
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                indices[0] = left+1;
                indices[1] = right+1;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return indices;
    }
}
