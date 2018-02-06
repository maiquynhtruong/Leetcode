/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    int total = 0;
    HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
    boolean[] visited = new boolean[2005];
    public int getImportance(List<Employee> employees, int id) {
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        Employee curEmp = map.get(id);
        findSubordinates(curEmp);
        return total;
    }
    public void findSubordinates(Employee curEmp) {
        total += curEmp.importance;
        visited[curEmp.id] = true;
        for (int subId : curEmp.subordinates) {
            findSubordinates(map.get(subId));
        }
    }
}
