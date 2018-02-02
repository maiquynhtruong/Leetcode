class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size(), total = 0;
        for (int i = n-3; i >= 0; i--) {
            cost[i] = cost[i] + min(cost[i+1], cost[i+2]);     
        }
        return min(cost[0], cost[1]);
    }
};
