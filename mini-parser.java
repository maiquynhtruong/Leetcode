/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    // "[123,[456,[789]]]"
    // "[[123],[456,[789]]]"
    // "[[123], 321,[[456],[789], [101, 112], 131]]"
    public NestedInteger deserialize(String str) {
        if (str.isEmpty()) return null;
        if (str.charAt(0) == '[') return new NestedInteger(Integer.valueOf(str));
        NestedInteger curInt;
        Stack<NestedInteger> s = new Stack<NestedInteger>();
        int l = 0; // points to start of number substring
        int r = 0; // points to end of number substring
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (curInt != null) s.push(curInt);
                curInt = new NestedInteger();
            } else if (c == ']') {
                String num = str.substring(l, r);
                if (!num.isEmpty()) curInt.add(new NestedInteger(Integer.valueOf(num)));
                if (!s.isEmpty()) {
                    NestedInteger prevInt = s.pop();
                    prevInt.add(curInt);
                    curInt = prevInt;
                }
            } else if (c == ',') {
                if (s.charAt(i-1) != ']') {
                    String num = str.substring(l, r);
                    curInt.add(new NestedInteger(Integer.valueOf(num)));
                }
            }
            l = r + 1;
        }
    }
    return curInt;
}

