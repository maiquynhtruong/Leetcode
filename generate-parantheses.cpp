class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> list;
        string str = "";
        generate(list, n, str, 0, 0);
        return list;        
    }
    
    void generate(vector<string> &list, int n, string str, int left, int right) {
        if (str.size() == 2*n) {
            list.push_back(str);
            return;
        }
        if (left < n) generate(list, n, str + "(", left + 1, right);
        if (right < left) generate(list, n, str + ")", left, right + 1);
    }
};
