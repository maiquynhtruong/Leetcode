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
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> s = new Stack<NestedInteger>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger integer = new NestedInteger();
                s.push(integer);
            } else if (c == ']') {
                NestedInteger integer = s.pop();
                NestedInteger prevInt = s.pop();
                prevInt.add(integer);
            } else if (c == ',') {
                if (s.charAt(i-1) != ']') {
                    NestedInteger integer = s.pop();
                    NestedInteger prevInt = s.pop();
                    prevInt.add(integer);
                }
            } else {
                NestedInteger integer = s.pop();
                int cur = integer.getInteger();
                s.push(integer.setInteger(cur*10 + c - '0');
            }
        }
    }
}

