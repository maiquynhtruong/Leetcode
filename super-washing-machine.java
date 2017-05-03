public class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i-1] + machines[i-1];
        int average = 0, res = 0;
        if (sum[n] % n != 0) return -1;
        else average = sum[n] / n;
        for (int i = 0; i < n; i++) {
            int left = i * average - sum[i];
            int right = (n-i-1) * average - (sum[n] - sum[i] - machines[i]);
            if (left > 0 && right > 0) res = Math.max(res, Math.abs(left) + Math.abs(right));
            else res = Math.max(res, Math.max(Math.abs(left), Math.abs(right)));
        }
        return res;
    }
}
