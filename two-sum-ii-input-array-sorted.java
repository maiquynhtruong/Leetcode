class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int index = findRemainder(numbers, i, target);
            
            if (numbers[i] + numbers[index] == target) 
                return new int[] {i+1, index+1};
        }
        return null;
    }
    
    public int findRemainder(int[] numbers, int index, int target) {
        int low = index+1, high = numbers.length-1, key = target - numbers[index];
        
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (numbers[mid] <= key) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
