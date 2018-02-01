class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int total1 = 0, total2 = 0;
        for (int i = 0; i < cost.size(); ) {
            if (cost[i+1] <= cost[i+2]) {
                total1 += cost[i+1];
                i = i+1;
            } else {
                total1 += cost[i+2];
                i = i+2;
            }
        }
        for (int i = 1; i < cost.size(); ) {
            if (cost[i+1] <= cost[i+2]) {
                total2 += cost[i+1];
                i = i+1;
            } else {
                total2 += cost[i+2];
                i = i+2;
            }
        }
        return min(total1, total2);
    }
};
