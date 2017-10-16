class Solution {
public:
    struct block {
        int left, right, height;
        block(int l, int r, int h) {left = l; right = r; height = h;}
    };
    vector<int> fallingSquares(vector<pair<int, int>>& positions) {
        vector<block> blocks;
        vector<int> ans;
        int maxHeight = 0;
        for (int i = 0; i < positions.size(); i++) {
            int maxH = 0, left = positions[i].first, right = positions[i].first+positions[i].second, height = positions[i].second;
            for (int j = blocks.size()-1; j >= 0; j--) {
                if (blocks[j].left <= left && blocks[j].right > left || blocks[j].left >= left && blocks[j].left < right) {
                    maxH = max(maxH, blocks[j].height);
                }
                // cout << "i= " << i << ", j= " << j << ", left= " << blocks[j].left << ", right= " << blocks[j].right << ", maxH= " << maxH << "\n";
            }
            height += maxH;
            blocks.push_back(block(left, right, height));
            maxHeight = max(maxHeight, height);
            ans.push_back(maxHeight);
        }
        return ans;
    }
};
