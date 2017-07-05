public class Solution {  
    public static String outputContestMatches(int n) {
        StringBuilder s = new StringBuilder();
        ArrayList<String> q = new ArrayList<String>();
        int num = n;
        for (int i = 0; i < n; i++) q.add(String.valueOf(i));
        while (q.size() > 1) {
            ArrayList<String> cur = new ArrayList<String>();
            for (int i = 0; i < q.size()/2; i++) 
                cur.add("(" + q.get(i) + "," + q.get(q.size()-i-1) + ")");
            q = cur;
        }
    }
    public static void main (String args[]) {
        
    }
}
