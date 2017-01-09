public class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return i-1;
            }
        }
        return nums.length-1;
    }
}

/** O(logN) **/
import java.util.*;
import java.lang.*;
import java.io.*;
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] nums = new int[] {1,2,3,4,5,6,7,3,1};
		System.out.println(findPeakElement(nums));
	}
	public static int findPeakElement(int[] nums) {
		int low = 0, high = nums.length-1;
		while (low < high) {
			int mid = (low + high) / 2;
			System.out.println("low= " + low + ", high= " + high + ", mid= " + mid);
			if (nums[mid] < nums[mid+1]) {
				low = mid+1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}

