public class Solution {
    public List<Integer> getRow(int rowIndex) {
        /**
         * [1]
         * [1,1]
         * [1,2,1]
         * [1,3,3,1]
         **/
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> helper = new ArrayList<Integer>();
        helper.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(1);
            for (int j = 1; j < helper.size(); j++) {
                res.add(helper.get(j) + helper.get(j-1));
            }
            res.add(1);
            helper = res;
            res = new ArrayList<Integer>();
        }
        return helper;
    }
    
    // Best solution
    
    public List<Integer> getRow(int rowIndex) {
        /**
         * [1]
         * [1,1]
         * [1,2,1]
         * [1,3,3,1]
         **/
        List<Integer> res = new ArrayList<Integer>(Collections.nCopies(rowIndex+1, 0));
        res.set(0,1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j-1));
            }
        }
        return res;
    }
}
