class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if (checkPalindrome(s)) return true;
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i) != s.charAt(n-i-1)) 
                if (checkPalindrome(s.substring(i+1, n-i)) || checkPalindrome(s.substring(i, n-i-1))) return true;
        }
        return false;
    }
    
    public boolean checkPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i) != s.charAt(n-i-1)) return false;
        }
        return true;
    }
}
