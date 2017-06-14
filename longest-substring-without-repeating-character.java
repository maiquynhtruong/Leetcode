public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashSet<Character> charSet = new HashSet<Character>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            // System.out.println("i= " + i + ", j= " + j + ", set= " + charSet.toString());
            if (!charSet.add(s.charAt(i))) {
                while (s.charAt(j) != s.charAt(i)) charSet.remove(s.charAt(j++));
                j++;
            }
            if (charSet.size() > maxLen) {
                maxLen = charSet.size();
            }
        }
        return maxLen;
    }
}
