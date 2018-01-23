class Solution {
public:
    int trap(vector<int>& height) {
        int prev_height = 0, volume = 0;
        for (int i = 1; i < height.size(); i++) {
            if (height[i] < height[i-1]) {
                if (prev_height < height[i-1]) prev_height = height[i-1];
            } else if (height[i] > height[i-1]) {
                if (prev_height < height[i]) prev_height = height[i];
            }
            volume += prev_height - height[i];
        }
        return volume;
    }
};
