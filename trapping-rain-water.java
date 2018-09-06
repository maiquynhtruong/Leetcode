class Solution {
    public int trap(int[] hs) {
        int res = 0;
        for (int i = 0; i < hs.length; i++) {
            int maxL = 0, maxR = 0;
            for (int j = 0; j < i; j++) maxL = Math.max(maxL, hs[j]);
            for (int j = i+1; j < hs.length; j++) maxR = Math.max(maxR, hs[j]);
            res += Math.max(0, Math.min(maxL, maxR) - hs[i]);
        }
        return res;
    }
}
