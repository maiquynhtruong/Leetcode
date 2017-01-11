/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
	public static void main (String[] args) throws java.lang.Exception
	{
		String[] strs = new String[]{"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(shortestWordDistance(hm, strs, "practice", "coding"));
	}
	public static int shortestWordDistance(HashMap<String, ArrayList<Integer>> hm, String[] strs, String word1, String word2) {
		for (int i = 0; i < strs.length; i++) {
			if (!hm.containsKey(strs[i])) {
				hm.put(strs[i], new ArrayList<Integer>());
			}
			ArrayList<Integer> indices = hm.get(strs[i]);
			indices.add(i);
		}
		ArrayList<Integer> index1 = hm.get(word1);
		ArrayList<Integer> index2 = hm.get(word2);
		int smallest = Integer.MAX_VALUE;
		for (int i : index1) {
			for (int j : index2) {
				if (Math.abs(i-j) < smallest) {
					smallest = Math.abs(i-j);
				}
			}
		}
		return smallest;
	}
}
