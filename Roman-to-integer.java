import java.util.*;
public class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        m.put("I", 1); m.put("II", 2); m.put("III", 3); m.put("V", 5);
        m.put("X", 10); m.put("L", 50); m.put("C", 100); m.put("D", 500); 
        m.put("M", 1000);
        int n = m.get(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            if (m.get(s.substring(i, i+1)) <= m.get(s.substring(i-1, i))) {
                n += m.get(s.substring(i, i+1));
            } else {
                n += m.get(s.substring(i, i+1)) - 2 * m.get(s.substring(i-1, i));
            }
        }
        return n;
    }
}
