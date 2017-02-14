/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone o = new Ideone();
		int[] nums = new int[] {1,0,1,1,0};
		System.out.println(o.findMaxConsecutiveOnes(nums));
	}
	public int findMaxConsecutiveOnes(int[] nums) {
		int zero = 0, k = 1; // at most k zeros can be flipped
		int maxCon = 0;
		for (int l = 0, h = 0; h < nums.length; h++) {
			if (nums[h] == 0) zero++;
			if (zero > k) {
				if (nums[l++] == 0) zero--;
			}
			maxCon = Math.max(h - l + 1, maxCon);
		}
		return maxCon;
	}
}
