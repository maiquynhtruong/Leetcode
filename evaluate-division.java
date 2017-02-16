/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String[][] equations = new String[][]{
			{"a", "b"}, {"b", "c"}
		};
		double[] values = new double[] {2.0, 3.0};
		String[][] queries = new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
		Ideone o = new Ideone();
		double[] results = o.calcEquation(equations, values, queries);
		System.out.println(Arrays.toString(results));
	}
	
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, HashMap<String, Double>> hm = new HashMap<String, HashMap<String, Double>>();
		for (int i = 0; i < equations.length; i++) {
			String[] strs = equations[i];
			if (!hm.containsKey(strs[0])) {
				HashMap<String, Double> sub = new HashMap<String, Double>();
				hm.put(strs[0], sub);
			}
				hm.get(strs[0]).put(strs[1], values[i]);
				if (!hm.containsKey(strs[1])) {
					HashMap<String, Double> sub = new HashMap<String, Double>();
					hm.put(strs[1], sub);
				}
				hm.get(strs[1]).put(strs[1], 1/values[i]);
		}
		double[] results = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
		    if (hm.containsKey(queries[i][0])) {
			    HashMap<String, Double> sub = hm.get(queries[i][0]);
			    if (sub.containsKey(queries[i][1])) results[i] = sub.get(queries[i][1]);
			    else results[i] = -1.0;
		    } else {
			    results[i] = -1.0;
		    }
		}
		return results;   
	    }
}
