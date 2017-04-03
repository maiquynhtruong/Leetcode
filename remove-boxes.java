public class Solution {
    public int removeBoxes(int[] boxes) {
        remove(boxes);
    }
    public int remove(int[] boxes) {
        if (boxes.length == 0) return 0;
        res = 0;
        for (int i = 0, j = i+1;i < boxes.length; i++) {
            while (j < boxes.length && boxes[i] == boxes[j]) j++;
            int[] newBoxes = new int[boxes.length - (j - i)];
            for (int k = 0, p = 0; k < newBoxes.length; k++) {
                if (k == i) k = j;
                newBox[p++] = boxes[k];
            }
            res = Math.max(res, remove(newBoxes) + (j-i) * (j-i));
        }
        return res;
    }
}
