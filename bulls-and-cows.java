public class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.size(); i++) {
            map.put(secret.charAt(i), i);
        }
        int bull = 0, cow = 0;
        for (int i = 0; i < guess.size(); i++) {
            if (map.containsKey(secret.charAt(i)) {
                if (map.get(secret.charAt(i) == i) bull++;
                else cow++;
                    
            }
        }
        return bull + "A" + cow + "B";
    }
}
