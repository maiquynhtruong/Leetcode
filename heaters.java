
/**
Solved using binary search
**/
import java.util.*;
import java.lang.*;
import java.io.*;
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone m = new Ideone();
		int[] houses = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] heaters = new int[] {1,4,9};
		System.out.println("radius: " + m.findRadius(houses, heaters));
	}
	// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
	// [1], 2, 3, [4], 5, 6, 7, 8, [9], 10, 11, 12
	// 1, 2, [3], 4, 5, 6, [7], 8, [9], 10, 11, 12
	
	public int findRadius(int[] houses, int[] heaters) {
		long left = -1, right = 10000000000L;
		while (left + 1 < right) {
			long mid = (left + right) / 2;
			int i = 0, j = 0;
			while (i < houses.length && j < heaters.length) {
				if (houses[i] - heaters[j] <= mid) {
					i++;
				} else {
					j++;
				}
			}
			if (i >= houses.length) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return (int) right;
	}
}
