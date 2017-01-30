public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (s.trim().length() <= 0) return "";
        s = sb.reverse().toString();
        String[] strs = s.split(" +");
        // System.out.println(Arrays.toString(strs));
        StringBuilder sb1 = new StringBuilder("");
        for (String str : strs) {
            System.out.println("1" + str);
            StringBuilder temp = new StringBuilder(str);
            sb1.append(temp.reverse() + " ");
        }
        return sb1.toString().trim();
    }
}
