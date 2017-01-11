public class Solution {
    public List<List<Integer>> generate(int numRows) {
        // [1]
        // [1,1]
        // [1,2,1]
        // [1,3,3,1]
        // [1,4,6,4,1]
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows > 0) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            list.add(temp);
            for (int i = 1; i < numRows; i++) {
                temp = new ArrayList<Integer>();
                temp.add(1);
                List<Integer> temp2 = list.get(i-1);
                for (int j = 1; j < temp2.size(); j++) {
                    temp.add(temp2.get(j) + temp2.get(j-1));
                }
                temp.add(1);
                list.add(temp);
            }
        }
        return list;
    }
}
