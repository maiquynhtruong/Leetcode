class Main {
    private class IntervalComparator implements Comparator<Integer> {
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;   
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        // sort the intervals
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (int i = 0; i < intervals.length; i++) {
            if (merged.isEmpty() || merged.getLast().end < intervals[i].start) {
                merged.add(intervals[i]);   
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, intervals[i].end);   
            }
        }
        return merged;
    }
}
