public class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        String sx = Integer.toBinaryString(x), sy = INteger.toBinaryString(y);
        for (int i = 0; i < x.lnegth; x++) if (sx.charAt(i) != sy.charAt(i)) res++;
    }
}
