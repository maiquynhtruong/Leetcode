public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length(), i;
        for (i = n-1; i >= 0; i--) {
              if (checkPalindrome(s, i)) break;
        }
        String reversed = "";
        for (int j = n-1; j > i; j--) reversed += s.charAt(j);
        return reversed + s;
    }
    public boolean checkPalindrome(String s, int end) {
        for (int i = 0; i < (end+1)/2; i++) {
            if (s.charAt(i) != s.charAt(end-i))
                return false;
        }
        return true;
    }
}
