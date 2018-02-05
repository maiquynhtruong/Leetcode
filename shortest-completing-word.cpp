class Solution {
public:
    struct compare {
        bool operator()(const std::string& first, const std::string& second) {
            return first.size() < second.size();
        }
    };
    bool compareStrings(int freq[], int licenseFreq[], string word, set<char> &plateChars) {
        for (int i = 'a'; i <= 'z'; i++) freq[i] = 0;
        for (int i = 0; i < word.size(); i++) freq[word[i]]++;
        
        for (set<char>::iterator itr = plateChars.begin(); itr != plateChars.end(); ++itr)
        {
            //cout << *itr << " " << freq[*itr] << " " << licenseFreq[*itr] << endl;
            if (freq[*itr] < licenseFreq[*itr]) return false;
        }
        return true;
    }
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        int charSize = 'z' + 1;
        int freq[charSize], licenseFreq[charSize];
        set<char> plateChars;
        for (int i = 'a'; i <= 'z'; i++) licenseFreq[i] = 0;
        for (int i = 0; i < licensePlate.size(); i++) {
            if (isalpha(licensePlate[i])) {
                licenseFreq[tolower(licensePlate[i])]++;
                plateChars.insert(tolower(licensePlate[i]));
            }
        }
        compare c;
        sort(words.begin(), words.end(), c);
        for (int i = 0; i < words.size(); i++) {
            cout << words[i] << "\n";
            if (compareStrings(freq, licenseFreq, words[i], plateChars)) return words[i];
            //cout << "\n";
        }
        return "";
    }

};
