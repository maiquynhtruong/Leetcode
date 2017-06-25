public class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] incoming = new int[numCourses];
        for (int i = 0; i < prereq.length; i++) {
            incoming[prereq[i][1]]++;
            graph[prereq[i][0]].add(prereq[i][1]);
        }
        
        
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll(); 
            count++;
            
        }
    }
}
