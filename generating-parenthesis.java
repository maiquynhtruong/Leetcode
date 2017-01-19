/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(generateParenthesis(4));
	}
	public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        if (n == 0) return res;
        else {
            Set<String> oldSet = new HashSet<String>();
            oldSet.add("");
            Set<String> newSet;
            for (int i = 0; i < n; i++) {
                newSet = new HashSet<String>();
                for (String str : oldSet) {
                    newSet.add(str + "()");
                    newSet.add("()" + str);
                    newSet.add("(" + str + ")");
                }
                System.out.println(newSet);
                oldSet = new HashSet<String>(newSet);
            }
            return new LinkedList(oldSet);
        }
    }
}
