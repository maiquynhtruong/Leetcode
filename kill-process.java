public class Solution {
    List<Integer> res = new ArrayList<Integer>();
        
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        res.add(pid, ppid, kill);
        for (int i = 0; i < pid.size(); i++)
            if (ppid.get(i) == kill) {
                killProcess(pid, ppid, pid.get(i));
            }
        }
    }
    
    public static void main (String[] args) {
        int kill = 5;
        List<Integer> pid = new ArrayList(Arrays.asList({1, 3, 10, 5})); //maybe wrong syntax here
        List<Integer> ppid = new ArrayList(Arrays.asList({3, 0, 5, 3})); //maybe wrong syntax here
        System.out.println(res);
    }
}
