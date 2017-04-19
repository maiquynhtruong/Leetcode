public class Solution {
    public int checkRecord(int n) {
        int unrewardable = 0;
        for (int cnt = 2; cnt <= n; cnt++)
            unrewardable += (n-cnt+1) * ((int) Math.pow(3, n-cnt));
        for (int cnt = 3; cnt <= n; cnt++) 
            unrewardable += (n-cnt+1) * ((int) Math.pow(3, n-cnt));
        return ((int) Math.pow(3, n)) - unrewardable;
    }
}
