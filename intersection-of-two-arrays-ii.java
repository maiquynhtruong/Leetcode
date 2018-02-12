class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i1 = 0; i1 < n1; i1++) {
            if (!map.containsKey(nums1[n1])) map.put(nums1[n1], 0);
            map.put(nums1[n1], map.get(nums1[n1]) + 1);
        }
        for (int i2 = 0; i2 < n2; i2++) {
            if (map.containsKey(nums2[i2])) {
                nums2[i2] = -1;
                map.put(nums2[i2], map.get(nums2[i2]) + 1);
                if (map.get(nums2[i2]) == 0) map.remove(nums2[i2]);
            }
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i2 = 0; i2 < n2; i2++) {
            if (nums2[i2] != -1) list.add(nums2[i2]);
        }
        return list.toArray(new Integer[list.size()]);
    }
}
