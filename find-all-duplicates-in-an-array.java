/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] nums = new int[] {1,1};
		List<Integer> list = findDuplicates(nums);
		// System.out.println("result: ");
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	if (nums[Math.abs(nums[i])-1] < 0) {
        		res.add(Math.abs(nums[i]));
        	} else {
        		nums[Math.abs(nums[i])-1] *= -1;
        	}
        }
        return res;
    }
}
