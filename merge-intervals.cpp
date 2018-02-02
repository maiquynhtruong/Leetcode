/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> merge(vector<Interval>& intervals) {
        int n = intervals.size();
        vector<Interval> merged;
        // sort intervals according to first item
        for (int i = 0; i < n;) {
            int j = i, newEnd = intervals[i].end;
            for (j = i+1; intervals[j].start <= intervals[i].end; j++) {
                if (intervals[j].end > intervals[i].end) {
                    newEnd = max(newEnd, intervals[j].end);
                }
            }
            Interval interval(intervals[i].start, newEnd);
            merged.push_back(interval);
            i = j;
        }   
        return merged;
    }
};
