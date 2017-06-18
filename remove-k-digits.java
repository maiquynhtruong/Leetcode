public class Solution {
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        int[] s = new int[digits];
        int top = 0;
        for (int i = 0; i < num.length(); i++)
            int cur = Character.getNumericValue(num.charAt(i));
            while (top > 0 && s[top-1] > c && k > 0) {
                top--;
                k--;
            }
            s[top++] = cur;
        }
        i = 0;
        while (i < digits && s[i] == '0') i++;
        return i == digits ? "0" : new String(s, i, digits - i);
        "143", k = 3 -> "0"
        "1432", k = 3 -> "1"
        "14323", k = 3 -> "12"
        "143236", k = 3 -> "123"
        "1432365", k = 3 -> "1235"
        "14323659", k = 3 -> "12359"
        "14323659"
    }
}
