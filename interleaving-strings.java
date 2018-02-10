class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length()-1, n2 = s2.length()-1, n3 = s3.length()-1;
        if (n1 + n2 + 1 != n3) return false;
        return tryPath(s1, s2, s3);
    }
    
    public boolean tryPath(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 == 0 && n2 == 0 && n3 == 0) return true;
        boolean result = false;
        n1--; n2--; n3--;
        if (n1 > 0 && n3 > 0 && s1.charAt(n1) == s3.charAt(n3)) {
            result = result || tryPath(s1.substring(0, n1-1), s2, s3.substring(0, n3-1));
        }
        if (n2 > 0 && n3 > 0 && s2.charAt(n2) == s3.charAt(n3)) {
            result = result || tryPath(s1, s2.substring(0, n2-1), s3.substring(0, n3-1));
        } 
        return result;
    }
}
