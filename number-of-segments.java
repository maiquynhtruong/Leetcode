import java.io.*;
import java.util.*;

class Solution {
  static int countSegments(String s) {
    int cnt = 0;
    s = " " + s + " ";
    for (int i = 1; i < s.length(); i++) {
        if (Character.isSpace(s.charAt(i)) && !Character.isSpace(s.charAt(i-1))) {
            cnt++;          
        } 
    }
    return cnt;
  }

  public static void main(String[] args) {
      String s = "Hello, my name is John a;jg dlsjgl dshgl ";
      System.out.println(countSegments(s));
  }

}
