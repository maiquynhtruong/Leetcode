class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> copyOfNums1(nums1);
        int i = 0, j = 0, index = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (copyOfNums1[i] <= nums2[j]) {
                    nums1[index++] = copyOfNums1[i++];
                } else if (copyOfNums1[i] > nums2[j]) {
                    nums1[index++] = nums2[j++];
                }    
            } else if (i < m) {
                nums1[index++] = copyOfNums1[i++];   
            } else if (j < n) {
                nums1[index++] = nums2[j++];   
            }
        }
    }
};
