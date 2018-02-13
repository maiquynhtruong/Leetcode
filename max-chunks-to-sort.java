class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] max = new int[n], min = new int[n];
        for (int i = 0; i < n; i++) {
            max[i] = max[i-1];
            if (arr[i] > max[i-1]) max[i] = arr[i];
            min[i] = min[i-1];
            if (arr[i] < min[i-1]) min[i] = arr[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (max[i] < min[i+1]) res++;
        }
        return res;
    }
}
