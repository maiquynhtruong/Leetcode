/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	class Node {
		int value;
		Node left;
		Node right;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		  /** 
      Example tree:
                          10
                 5                21      
              3    7           15      35
            2  4           13      18      89
                        12  14   16  20
      **/
	}
	
	public static int findLargestSmaller(int x, Node root)  {
		Node cur = root; 
		int lastSmall = -1;
		while (cur != null) {
			if (cur.value >= x) {
				cur = cur.left;
			} else {
				lastSmall = cur.value;
				cur = cur.right;
			}
		}
		return lastSmall;
	}
}
