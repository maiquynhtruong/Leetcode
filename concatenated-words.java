/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public class TrieNode {
		TrieNode[] links;
		boolean isEnd;
		public TrieNode() {
			links = new TrieNode[26];
			isEnd = false;
		}
	}
	
	public class Trie {
		TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		
		void insert(String word) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				int index = c - 'a'
				if (cur.links[index] == null) {
					cur.links[index] = new TrieNode;
				}
				cur = cur.links[index];
			}
			cur.isEnd = true;
		}
		
		boolean isConcat(String word, int offset, TrieNode cur, int num) {
			if (offset == word.length() || num > 1) {
				return true;
			}
			for (int i = 0; i < word.length(); i++) {
				int index = c - 'a';
				cur = cur.links[index];
				if (cur == null) {
					return false;
				}
				if (cur.isEnd() || isConcat(word, i+1, root, num+1)) {
					return true;
				}
			}
			return false;
		}
		
		public List<String> findAllConcatenatedWordsInADict(String[] words) {
			List<String> res = new ArrayList<>();
			if (word == null || words.length == 1) return res;
			Trie trie = new Trie();
			for (String word: words) {
				trie.insert(word);
			}
			for (String word: words) {
				if (trie.isConcat(word, 0, trie.root, 0)) {
					res.add(word);
				}
			}
			return res;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	}
}
