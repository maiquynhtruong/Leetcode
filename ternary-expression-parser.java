/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = "F?1:T?4:5";
		System.out.println(parseTernary(s));
	}
	
	public static String parseTernary(String expression) {
		if (expression.length() < 2) {
			return expression;
		} else {
			String[] strs = expression.substring(2).split(":");
			if (expression.charAt(0) == 'T') {
				return parseTernary(strs[0]);
			} else {
				return parseTernary(strs[1]);
			}
		}
	}
	
	public static String parseTernary(String expression) {
		if (expression == null || expression.length() == 0) {
			return expression;
		}
		Stack<Character> s = new Stack<Character>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);
			if (!s.empty() && s.peek() == '?') {
				s.pop(); // remove '?'
				char first = s.pop();
				s.pop(); // remove ':'
				char second = s.pop();
				if (c == 'T') {
					s.push(first);
				} else {
					s.push(second);
				}
			} else {
				s.push(c);
			}
		}
		return String.valueOf(s.peek());
	}
}
