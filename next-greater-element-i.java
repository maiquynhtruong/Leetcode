class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            if (indexMap.containsKey(nums1[i])) {
                for (int j = indexMap.get(nums1[i]); j < nums2.length; j++) {
                    if (nums2[j] > nums1[i]) {
                        res[i] = nums2[j];
                        break;
                    }
                }
            } 
        }
        return res;
    }
    
}
