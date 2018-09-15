class Solution {
    public String decodeString(String s) {
        Stack<StringBuffer> sbSt = new Stack<>();
        Stack<Integer> intSt = new Stack<>();
        StringBuffer curSb = new StringBuffer();
        int num = 0, n = s.length(), i = 0;
        char[] cs = s.toCharArray();
        while (i < n) {
            if (cs[i] == '[') {
                intSt.push(num);
                num = 0;
                sbSt.push(curSb);
                curSb = new StringBuffer();
            }
            if (Character.isLetter(cs[i])) {
                curSb.append(cs[i]);
            }
            if (cs[i] == ']') {
                String dupSt = genDup(intSt.pop(), curSb.toString());
                curSb = sbSt.pop();
                curSb.append(dupSt);
            }
            if (cs[i] >= '0' && cs[i] <= '9') {
                num = num * 10 + cs[i] - '0';
            }
            i++;
        }
        return curSb.toString();
    }
    
    public String genDup(int times, String st) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < times; i++) sb.append(st);
        return sb.toString();
    }
}

/**
3[a2[c]]
generateDup(2)
    
**/
