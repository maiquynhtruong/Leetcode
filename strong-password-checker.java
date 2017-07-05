public class Solution {
    public int strongPasswordChecker(String s) {
        int res = 0;
        boolean lowerCase, upperCase, oneDigit;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) lowerCase = true;
            if (Character.isUpperCase(s.charAt(i))) upperCase = true;
            if (Character.isDigit(s.charAt(i))) oneDigit = true;
            if (s.charAt(i) == s.charAt(i-1)) {
                if (repeating >= 2) res++; else repeating++;
            } else repeating = 0;
        }
        if (s.length() < 6) res += 6 - s.length();
        if (s.length() > 20) res += s.length() - 20;
        if (!lowerCase) res++;
        if (!upperCase) res++;
        if (!oneDigit) res++;
    }
}
