public class Solution {
    // ['A','A','A','B','B','B'], n = 2
    // ['A','A','A','A','A','B','B','C','C'], n = 2
    // A -> B -> C -> A -> B -> D -> A -> idle -> idle -> A -> idle -> idle -> A
    public int leastInterval(char[] tasks, int n) {
        Queue<String> q = new LinkedList<String>();
        LinkedList<String> schedule = new LinkedList<String>();
        int[] ts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            if (ts[tasks[i]-'a'] == 0) q.add(String.valueOf(tasks[i]-'a'));
            ts[tasks[i]-'a']++;
        }
        int numTasks = 0;
        while (!q.isEmpty()) {
            String s = q.poll();
            if (q.size() < n) q.add("idle");
            else {
                for (int i = 0; i < ts.length; i++) 
                    if (ts[i] > 0 && String.valueOf(i+'a') != q.peek()) {
                        q.add(String.valueOf(i+'a'));
                        break;
                    }
            }
            schedule.add(c);
        }
    }
}
