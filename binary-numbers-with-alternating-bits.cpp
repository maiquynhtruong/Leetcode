class Solution {
public:
    bool hasAlternatingBits(int n) {
        int cur = n % 2;
        while (n) {
            n >>= 1;
            if (n % 2 == cur) return false;
            cur = !cur;
        }
        return true;
    }
};
