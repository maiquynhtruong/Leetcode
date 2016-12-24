public class WordDictionary {

    public TrieNode 
    {
        TrieNode links[];
        isWord = false;
        
        public TrieNode() {
            links =  new links[26];
            for (int i = 0; i < 26; i++) links[i] = null;
        }
    }
    TrieNode head = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = head;
        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if (cur.links[index] == null) 
            {
                cur = new TrieNode();
            }
            cur = cur.links[index];
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = head;
        for (int i = 0; i < word.length(); i++) 
        {
            if (word.charAt(i) == '.')
            {
                for (int j = 0; j < 26; j++) 
                {
                    if (cur.links[j] != null)
                    {
                        cur = cur.links[j];
                    }
                }
                
            } 
            else 
            {
                int index = word.charAt(i) - 'a';
                if (cur.links[index] != null) 
                {
                    cur = cur.links[index];
                }
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
