class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] pos = new int[n1+n2+1];
        for (int i = n1-1; i >= 0; i--) {
            for (int j = n2-1; j >= 0; j--) {
                pos[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int co = 0, n = 0;
        for (int p = n1+n2-1; p >= 0; p--) {
            n = pos[p] + co;
            pos[p] = n % 10;
            co = n / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < n1+n2; p++) {
            sb.append(pos[p]);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

/***


    1 2 3
    4 5 6
    7 3 8
  6 1 5    
4 9 2
5 6 0 8 8

3*6 = 18
2*6 = 12 + 1 = 13
1*6 = 6 + 1 = 7
--> 738

3*5 = 15
2*5 = 10 + 1 = 11
1*5 = 5 + 1 = 6
--> 615
----> 615 + 73 = "688" + "8" =  6888

3*4 = 12
2*4 = 8 + 1 = 9
1*4 = 4 
--> 492
----> 492 + 68 = "560" + "88" = 56088

**/
