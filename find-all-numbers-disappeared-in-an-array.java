import java.util.Arrays;
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        // for (int i : nums) System.out.print(i + " ");
        // System.out.println();
        
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length < 2) return res;
        // if (nums[0] == 2) {res.add(1); nums[0] = 1;}
        int need = 1;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == need) {
        		need++;
        	} else if (nums[i] - need > 0) {
        		for (int j = need; j < nums[i]; j++) {
        			res.add(j);
        		}
        		need = nums[i] + 1;
        	}
        }
		for (int j = need; j <= nums.length; j++) {
			res.add(j);
		}
        return res;
    }
}
