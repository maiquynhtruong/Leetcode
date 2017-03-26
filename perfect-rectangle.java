import java.util.*;
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        Set<String> hs = new HashSet<String>();
        int area = 0;
        for (int[] rec: rectangles) {
            x1 = Math.min(x1, rec[0]);
            x2 = Math.max(x2, rec[2]);
            y1 = Math.min(y1, rec[1]);
            y2 = Math.max(y2, rec[3]);
            
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
                
            String s1 = rec[0] + "," + rec[1];
            String s2 = rec[0] + "," + rec[3];
            String s3 = rec[2] + "," + rec[1];
            String s4 = rec[2] + "," + rec[3];
            
            if (!hs.add(s1)) hs.remove(s1); // those appear twice will be removed, those appear once will stay
            if (!hs.add(s2)) hs.remove(s2);
            if (!hs.add(s3)) hs.remove(s3);
            if (!hs.add(s4)) hs.remove(s4);
            
        }
        System.out.println("x1= " + x1 + ", y1= " + y1 + ", x2= " + x2 + ", y2= " + y2);
        if (!hs.contains(x1 + "," + y1) || !hs.contains(x1 + "," + y2) || !hs.contains(x2 + "," + y1) || !hs.contains(x2 + "," + y2) || hs.size() != 4) return false;
        return area == (y2 - y1) * (x2 - x1);
    }
}
