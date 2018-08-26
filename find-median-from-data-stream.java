class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minQueue, maxQueue; 
    public MedianFinder() {
        maxQueue = new PriorityQueue<>(1000, Collections.reverseOrder());
        minQueue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxQueue.offer(num);
        minQueue.offer(maxQueue.poll());
        
        if (maxQueue.size() < minQueue.size()) {
            maxQueue.offer(minQueue.poll());
        }
        
    }
    
    public double findMedian() {
        if (maxQueue.size() == minQueue.size()) return (maxQueue.peek() + minQueue.peek())/2.0;
        else return maxQueue.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
