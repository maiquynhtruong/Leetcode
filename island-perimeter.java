/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[][] grid = {
			{1,1},
			{1,1}};	
 		System.out.println(islandPerimeter(grid));
	}
	public static int islandPerimeter(int[][] grid) {
        int i = 0, j = 0;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // System.out.println("main. i= " + i + ", j= " + j);
                    return findPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }
    public static int findPerimeter(int[][] grid, int i, int j) {
        int sum = 0;
        System.out.println("i= " + i + ", j= " + j);
        grid[i][j] = -1;
        if (isValid(grid, i, j-1)) {
        	if (grid[i][j-1] == 1) sum = findPerimeter(grid, i, j-1);
        	else if (grid[i][j-1] == 0) sum = 1;
        } else sum = 1;
        if (isValid(grid, i, j+1)) {
        	if (grid[i][j+1] == 1) sum += findPerimeter(grid, i, j+1);
        	else if (grid[i][j+1] == 0) sum += 1;
        } else sum += 1;
        if (isValid(grid, i-1, j)) {
        	if (grid[i-1][j] == 1) sum += findPerimeter(grid, i-1, j);
        	else if (grid[i-1][j] == 0) sum += 1;
        } else sum += 1;
        if (isValid(grid, i+1, j)) {
        	if (grid[i+1][j] == 1) sum += findPerimeter(grid, i+1, j);
        	else if (grid[i+1][j] == 0) sum += 1;
        } else sum += 1;
        System.out.println("i= " + i + ", j= " + j + ", sum= " + sum);
        return sum;
    }
    public static boolean isValid(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) return true;
        else return false;
    }
}
