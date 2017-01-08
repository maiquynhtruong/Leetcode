/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int num = 12;
		System.out.println(findComplement(num));
	}
	
	public static int findComplement(int num) {
		// System.out.println(Integer.toBinaryString(num));
		char[] bits = Integer.toBinaryString(num).toCharArray();
		int m = 1, retVal = 0;
		for (int i = bits.length-1; i >= 0; i--) {
			if (bits[i] == '0') {
				retVal += m;
			}
			m *= 2;
		}
		return retVal;
	}
	
	public static int findComplement(int num) {
		int m = (Integer.highestOneBit(num) << 1) - 1;
		return num ^ m;
	}
}
