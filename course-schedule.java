public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        while (!set.empty()) {
            int v = set.pop();
            for (int i : getVertices(v)) {
                if (neighbors[i].contains(v))set.push(i);   
            }
            list.add(v);
        }
    }
}
