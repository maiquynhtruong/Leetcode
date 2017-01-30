/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(countSegments("Hello, my name is John"));
	}
	static int countSegments(String s) {
		int res = 0; 
		boolean newWord = true;
		for (char c : s.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				if (newWord) {res++; newWord = false;}
			} else {
				newWord = true;
			}
		}
		return res;
	}
}
