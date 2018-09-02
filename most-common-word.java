class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < banned.length; i++) set.add(banned[i]);
        HashMap<String, Integer> map = new HashMap<>();
        paragraph = paragraph.replaceAll("[!?',;.]", "");
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!set.contains(words[i])) {
                if (!map.containsKey(words[i])) map.put(words[i], 0);
                map.put(words[i], map.get(words[i])+1);    
            }
            
        }
        int max = Integer.MIN_VALUE;
        String lfw = "";
        for (String word : map.keySet()) {
            if (map.get(word) > max) {
                max = map.get(word);
                lfw = word;
            }
        }
        return lfw;
    }
}
