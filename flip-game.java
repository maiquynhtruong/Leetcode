/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = "++++";
		System.out.println(generatePossibleNextMoves(s));
	}
	public static List<String> generatePossibleNextMoves (String s) {
		List<String> l = new LinkedList<String>();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
				StringBuilder sb = new StringBuilder(s);
				sb.replace(i, i+2, "--");
				l.add(sb.toString());
			}
		}
		return l;
	}
}
