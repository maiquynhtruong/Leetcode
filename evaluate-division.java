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
		HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<Double>> weights = new HashMap<String, ArrayList<Double>>();

		for (int i = 0; i < equations.length; i++) {
			if (!pairs.containsKey(equations[i][0])) {
				pairs.put(equations[i][0], new ArrayList<String>());
				weights.put(equations[i][0], new ArrayList<Double>());
			}
				if (!pairs.containsKey(equations[i][1])) {
					pairs.put(equations[i][1], new ArrayList<String>());
					weights.put(equations[i][1], new ArrayList<Double>());
				}
				pairs.get(equations[i][0]).add(equations[i][1]);
				weights.get(equations[i][0]).add(values[i]);
				pairs.get(equations[i][1]).add(equations[i][0]);
				weights.get(equations[i][1]).add(1/values[i]);
		}
		double[] results = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			    double retVal = dfs(queries[i][0], queries[i][1], 1.0, pairs, weights, new HashSet<String>());
			    if (retVal == 0.0) results[i] = -1.0; else results[i] = retVal;
		}
		return results;   
    	}	
    	public double dfs(String startNode, String endNode, double value, HashMap<String, ArrayList<String>> pairs, 
	    HashMap<String, ArrayList<Double>> weights, HashSet<String> visited) {
		if (visited.contains(startNode)) return 0.0;
		if (!pairs.containsKey(startNode)) return 0.0;
		if (startNode.equals(endNode)) return value;
		List<String> toNodes = pairs.get(startNode);
		visited.add(startNode);
		double retVal = 0.0;
		for (int i = 0; i < toNodes.size(); i++) {
		    String next = toNodes.get(i);
		    retVal = dfs(next, endNode, value * weights.get(startNode).get(i), pairs, weights, visited);
		    if (retVal != 0.0) {
			break;
		    }
		}
		visited.remove(startNode); // remove because there might be a case of a/b = 3.0 and c/b = 2.0
		return retVal;
    	}
}
