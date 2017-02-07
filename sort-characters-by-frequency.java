/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = "cccaaa";
		System.out.println(frequencySort(s));
	}
	
	public static String frequencySort(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character c = Character.valueOf(s.charAt(i));
			if (!hm.containsKey(c)) hm.put(c, 0);
			hm.put(c, hm.get(c) + 1);
		}
		PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<Map.Entry<Character, Integer>>(Collections.reverseOrder(Map.Entry.comparingByValue()));
		q.addAll(hm.entrySet());
		StringBuilder sb = new StringBuilder();
		// System.out.println(Arrays.toString(q.toArray()));
		
		while (!q.isEmpty()) {
			Map.Entry<Character, Integer> e = q.poll();
			String repeat = (new String(new char[e.getValue()])).replace("\0", String.valueOf(e.getKey()));
			// System.out.println(repeat + " ");
			sb.append(repeat);
		}
		return sb.toString();
		// return s;
		
	}
}
