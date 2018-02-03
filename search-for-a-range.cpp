class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size(), start = 0, end = n-1, mid, leftmost = -1, rightmost = -1;
        vector<int> range;
        while (start < end) {
            mid = start + (end-start)/2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        leftmost = end;
        start = end; end = n-1;
        while (start < end) {
            mid = start + (end-start)/2;
            if (nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid;
            }
        }
        rightmost = start;
        range.push_back(leftmost);
        range.push_back(rightmost);
        return range;
    }
};
