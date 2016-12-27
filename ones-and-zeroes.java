public class Solution {
    
	public int findMaxForm(String[] strs, int m, int n) {
// 		final String replace = (m > n) ? "0" : "1";
        final String replace = "0";
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// String replace = "0";
				// if (m > n) replace = "1";
				int count1 = s1.length() - s1.replace(replace, "").length();
				// if (count1 == 0) count1 = Math.max(s1.length(), s2.length());
				int count2 = s2.length() - s2.replace(replace, "").length();
				// if (count2 == 0) count2 = Math.max(s1.length(), s2.length());
				// if (s1.length() == s2.length())
					// return count2 - count1;
				if (count1 == count2) 
					return Integer.compare(s1.length(), s2.length());
				else
					return Integer.compare(count1, count2);
				// else 
				// return Integer.compare(count2, count1);
					// return Integer.compare(s1.length(), s2.length());
			}
		});
// 		final String replace1 = (m > n) ? "1" : "0";
        final String replace1 = "1";
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String s1, String s2) {
				int count1 = s1.length() - s1.replace(replace1, "").length();
				int count2 = s2.length() - s2.replace(replace1, "").length();
				if (count1 == count2) 
					return Integer.compare(s1.length(), s2.length());
				else
					return Integer.compare(count1, count2);
			}
		});
		int total = 0;
		// if (m > n) {
		// 	List<String> strL = Arrays.asList(strs);
		// 	Collections.reverse(strL); 
		// 	strs = strL.toArray(strs);
		// }
		// for (int i = 0; i < strs.length; i++) System.out.print(strs[i] + " ");
		// System.out.println();
		for (int i = 0; i < strs.length; i++) {
			String cur = strs[i];
			int count0 = cur.length() - cur.replace("0", "").length();
			int count1 = strs[i].length() - count0;
			if (count0 <= m && count1 <= n) {
				// System.out.println("s= " + strs[i] + ", count0= " + count0 + ", count1= " + count1);
				m -= count0;
				n -= count1;
				total++;
				// System.out.println("s= " + strs[i] + ", m= " + m + ", n= " + n);
			}
		}
		return total;
	}
}

// More intelligent solution
public class Solution {
	public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
		for (String s: strs) {
			int count0 = s.length() - s.replace("0", "").length();
			int count1 = s.length() - count0;
			
			for (int i = m; i >= count0; i--) {
				for (int j = n; j >= count1; j--) {
					dp[i][j] = Math.max(dp[i][j], 1 + dp[i-count0][j-count1]);
				}
			}
		}
		return dp[m][n];
	}
}
