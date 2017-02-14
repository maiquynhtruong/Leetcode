/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static int[] debug;
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] nums = new int[] {1};//, 1, 1, 1, 1};
		int S = 1;
		// debug = Arrays.copyOf(nums, nums.length);
		// debug = new int[nums.length];
		Ideone o = new Ideone();
		System.out.println(o.findTargetSumWays(nums, S));
	}
	
	// Backtracking backtracking all the way
	static int cnt = 0;
	public int findTargetSumWays(int[] nums, int S) {
		findSum(nums, 0, 0, S);
		return cnt;
    }
    
    public void findSum(int[] nums, int index, int cur, int S) {
    	// System.out.println("index= " + index + ", cur= " + cur + ", S= " + S);
    	// System.out.println(Arrays.toString(debug) + ", cur= " + cur);
    	if (index == nums.length) {
    		// System.out.println(Arrays.toString(debug) + ", cur= " + cur);
    		// System.out.println("done");
    		if (cur == S) cnt++; 
    		return;
    	} else {
	    	// if (cur < 0 || cur > S) return;
	    	// debug[index] = -nums[index];
	    	findSum(nums, index+1, cur-nums[index], S);
	    	// debug[index] = nums[index];
	    	findSum(nums, index+1, cur+nums[index], S);
	    	
    	}
    }
}
