/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }  
        }
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }
        ListNode head = new ListNode(0);
        ListNode pointer = head.next;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            
            if (tail.next != null) pq.add(tail.next);
        }
    }
}
