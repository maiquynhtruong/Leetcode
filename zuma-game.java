/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String board = "WWRRBBWW";
		String hand = "WRBRW";
		Ideone o = new Ideone();
		System.out.println(o.findMinStep(board, hand));
	}
	
	public int findMinStep(String board, String hand) {
		List<Character> boards = new ArrayList<Character>();
		for (char c : board.toCharArray()) boards.add(c);
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('B', 0); hm.put('G', 0); hm.put('R', 0); hm.put('Y', 0); hm.put('W', 0);
		for (char c : hand.toCharArray()) hm.put(c, hm.get(c) + 1);
        return find(boards, hm);
        
    }
    
    public int find(List<Character> boards, HashMap<Character, Integer> hm) {
    	removeAdjacents(boards);
    	if (boards.size() == 0) return 0;
    	if (isEmpty(hm)) return -1;
    	int cnt = 0;
    	int retVal = Integer.MAX_VALUE;
    	for (int i = 0; i < boards.size(); i++) {
    		char c = boards.get(i);
    		cnt++;
    		if (i == boards.size() || boards.get(i+1) != c) {
	    		int missing = 3 - cnt;
	    		if (missing <= hm.get(c)) {
	    			hm.put(c, hm.get(c) - missing);
	    			List<Character> temp = new ArrayList<Character>(boards);
	    			for (int j = i; j > i-cnt; j--) temp.remove(j);
	    			int next = find (temp, hm);
	    			if (next != -1) retVal = Math.min(next + missing, retVal);
	    			hm.put(c, hm.get(c) + missing);
	    		}
	    		cnt = 0;
    		}
    	}
    	if (retVal == Integer.MAX_VALUE) return - 1; else return retVal;
    }
    
    public void removeAdjacents(List<Character> board) {
    	int cnt = 0;
    	boolean done = true;
    	for (int i = 0; i < board.size(); i++) {
    		char c = board.get(i);
    		cnt++;
    		if (i == board.size()-1 || c != board.get(i+1)) {
    			if (cnt >= 3) {
	    			for (int j = i; j > i-cnt; j--) board.remove(j);
	    			done = false;
	    			break;
    			}
    			cnt = 0;
    		}
    	}
    	if (!done) removeAdjacents(board);
    }
    public boolean isEmpty(HashMap<Character, Integer> hand) {
    	for (int i : hand.values()) {
    		if (i > 0) return false;
    	}
    	return true;
    }
}
