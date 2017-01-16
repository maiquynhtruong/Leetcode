public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            String sub = str.substring(0,i+1);
            if (str.length() % sub.length() == 0) {
                int m = str.length() / sub.length();
                StringBuilder sb = new StringBuilder();
                for (int t = 0; t < m; t++) {
                    sb.append(sub);
                }
                if (str.equals(sb.toString())) return true;
            }
        }
        return false;
    }
}
