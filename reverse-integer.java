public class Solution {
    public int reverse(int x) {
        if (x == 0) return x;
        int sign = 1;
        if (x < 0) {sign = -1; x *= -1;}
        String s = new StringBuilder(String.valueOf(x)).reverse().toString();
        String max = String.valueOf(Integer.MAX_VALUE);
        System.out.println(s);
        if (s.length() < max.length() || s.compareTo(max) <= 0) 
            return sign * (Integer.valueOf(s));
        else return 0;
    }
}
