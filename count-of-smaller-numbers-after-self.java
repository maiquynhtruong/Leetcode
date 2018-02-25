class Solution {
    int[] smallerRight;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] indexes = new int[n];
        smallerRight = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, 0, n-1);
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            res.add(smallerRight[i]);
        }
        return res;
    }
    
    public void mergeSort(int[] nums, int[] indexes, int start, int end) {
        if (end <= start) return;
        int mid = (end+start)/2;
        
        mergeSort(nums, indexes, start, mid);
        mergeSort(nums, indexes, mid+1, end);
        merge(nums, indexes, start, end);
    }
    
    public void merge(int[] nums, int[] indexes, int start, int end) {
        int[] sortArr = new int[end - start + 1];
        int sortIndex = 0, rightCount = 0, mid = (start+end)/2, left = start, right = mid+1;
        
        while (left <= mid && right <= end) {
            if (nums[indexes[left]] > nums[indexes[right]]) {
                rightCount++;
                sortArr[sortIndex] = indexes[right++];
            } else {
                smallerRight[indexes[left]] += rightCount;
                sortArr[sortIndex] = indexes[left++];
            }           
            sortIndex++;
        }
        
        while (right <= end) {
            sortArr[sortIndex++] = indexes[right++];
        }
        while (left <= mid) {
            smallerRight[indexes[left]] += rightCount;
            sortArr[sortIndex++] = indexes[left++];
        }
        for (int i = start; i <= end; i++) {
            indexes[i] = sortArr[i-start];
        }
        
    }
}
