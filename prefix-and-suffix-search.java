class WordFilter {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= 10 && j <= words[i].length(); j++) {
                for (int k = 0; k <= 10 && k <= words[i].length(); k++) {
                    map.put(words[i].substring(0, j) + "." + words[i].substring(words[i].length()-k), i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        if (map.containsKey(prefix + "." + suffix)) return map.get(prefix + "." + suffix);
        else return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
