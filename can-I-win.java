import java.util.*;
public class Solution {
    HashMap<Integer, Boolean> hm;
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger+1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        hm = new HashMap<Integer, Boolean>();
        used = new boolean[maxChoosableInteger+1];
        return canFirstWin(desiredTotal);
    }
    
    public boolean canWin(int total) {
        if (total <= 0) return false;
        int usedArray = format(used);
        if (!hm.containsKey(usedArray)) {
            for (int i = 1; i <= used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!canWin(total - i)) {
                        hm.put(usedArray, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            hm.put(key, false);
        }
        return false;
    }
    
    public int binaryToInteger(boolean[] used) {
        int retVal = 0;
        for (boolean i : used) {
            retVal <<= 1;
            if (i) retVal |= 1;
        }
        return retVal;
    }
}
