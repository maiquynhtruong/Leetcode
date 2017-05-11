import java.util.*;
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger+1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        return canFirstWin(desiredTotal, 0, hm);
    }
    
    public boolean canFirstWin(int total, int chosen, HashMap<Integer, Boolean>) {
        
    }
}
