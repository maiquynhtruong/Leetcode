import java.util.*;
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger+1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        return canFirstWin(desiredTotal, 0, hm);
    }
    
    public boolean canWin(int total, boolean[] used, HashMap<Integer, Boolean> hm) {
        if (total < 0) return false;
        for (int i = 1; i <= MaxChoosableInteger; i++) 
            if (!used[i]) {
                used[i] = true;
                if (canWin(total - i, ))
                    hm.put(, true);
                used[i] = false;
            }
    }
    
    public int binaryToInteger(boolean[] used) {
           
    }
}
