
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

// Solved with TreeSet

public class Solution {
    
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
    // 1, 4, 9
    // 2, 5, 9
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses); Arrays.sort(heaters);
    	TreeSet<Integer> heats = new TreeSet<Integer>();
    	int maxDis = 0;
    	for (int i = 0; i < heaters.length; i++) heats.add(heaters[i]);
		for (int h = 0; h < houses.length; h++) {
			Integer heater1 = heats.ceiling(houses[h]);
			int m = Integer.MAX_VALUE;
			if (heater1 != null) m = Math.abs(heater1 - houses[h]);
			Integer heater2 = heats.floor(houses[h]);
			if (heater2 != null) m = Math.min(m, Math.abs(heater2 - houses[h]));
			maxDis = Math.max(maxDis, m);
		}
		return maxDis;
    }
}
