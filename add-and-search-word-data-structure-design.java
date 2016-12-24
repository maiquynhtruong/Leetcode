public class WordDictionary {

    public class TrieNode {
        TrieNode links[];
        boolean isWord = false;
        
        public TrieNode() {
            links =  new TrieNode[26];
            for (int i = 0; i < 26; i++) links[i] = null;
        }
    }
    TrieNode head = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = head;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.links[index] == null) {
                cur.links[index] = new TrieNode();
            }
            cur = cur.links[index];
        }
        cur.isWord = true;
    }
    

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchFrom(word, head);
    }
        
    public boolean searchFrom(String word, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
        	// System.out.println(word.charAt(i));
        	if (cur != null) {
        		
	            if (word.charAt(i) == '.') {
	                for (int j = 0; j < 26; j++) {
	                	// System.out.println(j + " " + cur.links[j]);
                        if (searchFrom(word.substring(i+1), cur.links[j]))
                            return true;
	                }
                cur = null;
	            } else {
	                int index = word.charAt(i) - 'a';
	               // if (cur.links[index] != null) {
	                    cur = cur.links[index];
	               // }
	            }
        	} else {
        		break;
        	}
        }
        return cur != null && cur.isWord;		
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
