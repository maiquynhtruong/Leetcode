class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        int charSize = 'z' + 1;
        int freq[charSize], licenseFreq[charSize];
        set<char> plateChars;
        for (int i = 0; i < licensePlate.size(); i++) {
            if (isalpha(licensePlate[i])) licenseFreq[tolower(licensePlate[i])]++;
            plateChars.insert(tolower(licensePlate[i]));
        }
        for (int i = 0; i < words.size(); i++) {
            if (compareStrings(freq, words[i])) return words[i];
        }
        return "";
    }
    
    
    
    bool compareStrings(int freq[], int licenseFreq[], string word, set<char> &plateChars;) {
        for (int i = 0; i < word.size(); i++) {
            freq[word[i]]++;
        }
        for (set<char>::iterator itr = plateChars.begin(); itr != plateChars.end(); ++itr)
        {
            if (freq[*itr] < licenseFreq[*itr]) return false;
        }
        return true;
    }
};
