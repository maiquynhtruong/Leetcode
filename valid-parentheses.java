public class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<Character>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                
                s.push(ch);
                System.out.println(s);
            } else {
                if (s.empty()) return false;
                char top = s.pop();
                if ((top == '(' && ch != ')') || (top == '{' && ch != '}') || (top == '[' && ch != ']')) {
                    return false;
                } 
            }
        }
        return s.empty();
    }
}
