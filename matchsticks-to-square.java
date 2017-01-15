/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int sum = 0;
		int[] nums = new int[] {1,1,2,2,2,2,1,1};
        for (int v : nums) sum += v;
        if (sum % 4 != 0) {
            System.out.println("1. " + false);
        } else {
        	// Arrays.sort(nums);
        	// reverse(nums);
        	int[] square = new int[4];
        	for (int i = 0; i < 4; i++) square[i] = 0;
        	System.out.println(makeSquare(nums, sum / 4, square, 0));
        	}
	}
	
	public static void reverse(int[] nums) {
		for (int i = 0; i < nums.length / 2; i++) {
			int temp = nums[i];
			nums[i] = nums[nums.length-i-1];
			nums[nums.length-i-1] = nums[i];
		}
	}
	public static boolean makeSquare(int[] nums, int part, int[] square, int index) {
		// System.out.println(square[0] + ", " + square[1] + ", " + square[2] + ", " + square[3]);
		if (index == nums.length) {
			System.out.println(square[0] + ", " + square[1] + ", " + square[2] + ", " + square[3]);
	        if (square[0] == part && square[1] == part && square[2] == part) 
	        	return true;
        	return false;
		}
        for (int i = 0; i < 4; i++) {
        	if (square[i] + nums[index] > part) continue;
		int j = i;
		while (--j >= 0) 
			if (square[i] == square[j])
				break;
		if (j < 0) continue;
    		square[i] += nums[index];
    		if (makeSquare(nums, part, square, index+1)) {
    			return true;
    		}
    		square[i] -= nums[index];
        }
        return false;
    }
}
