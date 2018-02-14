class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[i];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }

        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < D.length; j++) {
                int remainder = C[i] + D[j];
                cnt += map.getOrDefault(-1*remainder, 0);
            }
        
        return cnt;
    }
}
