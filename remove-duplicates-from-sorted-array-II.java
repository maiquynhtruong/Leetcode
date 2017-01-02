import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone m = new Ideone();
		int[] nums = new int[]{1,1,1,1,1};
		System.out.println(m.removeDuplicates(nums));
		for (int i = 0; i < nums.length; i++) 
			System.out.print(nums[i] + " " );
	}
 
	public int removeDuplicates(int[] nums) {
		if (nums.length < 3) return nums.length;
        int i1 = 0, i2 = 1, cur = 2;
        while(cur < nums.length) {
        	if (nums[i1] == nums[i2]) {
        		while (cur < nums.length && nums[cur] == nums[i2]) cur++;
        		System.out.println("cur= " + cur);
        		if (cur < nums.length) {nums[i2+1] = nums[cur++]; i1++;i2++;} 
        	} else {
        		nums[++i2] = nums[cur++];
        		i1++; 
        	}
        }
        return i2+1;
	}
}

/** More intelligent solution
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i < 2 || nums[j] > nums[i-2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
**/
