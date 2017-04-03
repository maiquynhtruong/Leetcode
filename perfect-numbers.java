public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int temp = num; // - 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) temp -= i + num/i;
        }
        return temp - 1 == 0;
    }
}
