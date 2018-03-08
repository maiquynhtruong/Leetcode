class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minBought = prices[0], maxDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] >= minBought) maxDiff = Math.max(maxDiff, prices[i] - minBought);
            else minBought = prices[i];
        }
        return maxDiff;
    }
}
