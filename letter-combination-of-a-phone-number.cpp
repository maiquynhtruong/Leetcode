class Solution {
public:
    void combineLetters(vector<string> &vec, map<char, string> &m, string s, char str[], int curLen) {
        if (curLen == s.size()) {
            vec.push_back(str);
        }
        for (int i = 0; i < m[s[curLen]].size(); i++) {
            str[curLen] = m[s[curLen]][i];
            combineLetters(vec, m, s, str, curLen+1);
            str[curLen] = '\0';
        }
    }
    vector<string> letterCombinations(string digits) {
        map<char, string> mapping;
        mapping['0'] = "";
        mapping['1'] = "";
        mapping['2'] = "abc";
        mapping['3'] = "def";
        mapping['4'] = "ghi";
        mapping['5'] = "jkl";
        mapping['6'] = "mno";
        mapping['7'] = "pqrs";
        mapping['8'] = "tuv";
        mapping['9'] = "wxyz";
        char str[digits.size()+1];
        str[digits.size()] = '\0';
        vector<string> vec;
        if (!digits.empty()) combineLetters(vec, mapping, digits, str, 0);
        return vec;
    }
    

};
