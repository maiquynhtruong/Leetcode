public class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        for (int i = 0; i < prereq.length; i++) {
            degree[prereq[i][1]]++;
            graph[prereq[i][0]].add(prereq[i][1]);
        }
        
        for (int i = 0; i < numCourses; i++) 
            if (degree[i] == 0) {
                q.add(i);
                count++;
            }
        
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll(); 
            for (int i : graph[v]) {
                degree[i]--;
                if (degree[i] == 0) {
                    q.add(i);
                    count++;
                }
            }
        }
        if (count == numCourses) { return true; }
        else { return false; }
    }
}
