public class Solution {
    public String removeKdigits(String num, int k) {
        "1432219", k = 3 -> "1219"
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        while (i < n && s.size() < n-k ) {
            int cur = Character.getNumericValue(num.charAt(i));
            if (s.peek() > cur) {
                s.pop(); s.push(cur);
            }
            
        }

    }
}

/**
        "143", k = 3 -> "0"
        "132", k = 3 -> "1"
        "123", k = 3 -> "12"
        "123", k = 3 -> "123"
        "1235", k = 3 -> "1235"
        "12359", k = 3 -> "12359"
        
*/
