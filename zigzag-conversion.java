public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        String ans = "";
        for (int i = 0; i < numRows; i++) {
            int j = i;
            ans += s.charAt(j);
            while (j < s.length()) {
                int next = 2 * (numRows - i - 1);
                if (next > 0) {
                	j += next;
                	if (j < s.length()) ans += s.charAt(j);
                }
                next = 2 * i;
                if (next > 0) {
                	j += next;
                	if (j < s.length()) ans += s.charAt(j);
                }
            }
        }
        return ans;
    }
}

/**
 a     i     q
 b   h j   p r
 c  g  k  o  s  x
 d f   l n   t v
 e     m     u
 **/
