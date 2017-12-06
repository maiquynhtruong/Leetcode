class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<int> curNum;
        vector<vector<int>> result;
        findSum(result, candidates, curNum, 0, target);
        return result;
    }
private:
    void findSum(vector<vector<int>> &result, vector<int>& candidates, vector<int>& curNum, int index, int remain) {
        if (remain == 0) {
            result.push_back(curNum);
            return;
        }
        for (int i = index; i < candidates.size() && remain >= candidates[i]; i++) {
            // if (i > 0 && candidates[i] == candidates[i-1]) continue;
            curNum.push_back(candidates[i]);
            findSum(result, candidates, curNum, i, remain - candidates[i]);
            curNum.pop_back(); 
        } 
    }
};
