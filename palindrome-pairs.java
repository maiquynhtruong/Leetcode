public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int j = 0; j <= cut.size(); j++) {
                String s1 = cur.substring(0, j));
                String s2 = cur.substring(j);
                if (isPalindrome(s1)) {
                    String revs2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(revs2) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(revs2), i);
                        res.add(list);
                    }
                }
            } 
            if (isPalindrome(s2)) {
                    String revs1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(revs1) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(revs1), i);
                        res.add(list);
                }
            }
        }
                return true;
    }
    puclic boolean checkPalindrome(String s) {
        
    }
}
