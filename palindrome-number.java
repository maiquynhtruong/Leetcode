public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int n = x, len = 1, p = 1;
        
        while (n > 9) {
            p *= 10; len++; n /= 10;   
        }
        // p = p / 10;
        for (int i = 0; i < len / 2; i++) {
            long last = x % 10;
            long first = x / p;
            if (last != first) {
                return false;
            }
            x =  x % p;
            x =  x / 10;
            p /= 100;
        }
        return true;
    }
}

/**
Best solution
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return ((x == rev) || (x == rev / 10));
    }
}
**/
