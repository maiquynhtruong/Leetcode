/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode even = head, odd = head, ptr = head;
        while (ptr != null && ptr.next != null) {
            odd = ptr.next;
            ptr = ptr.next.next;
            even.next = ptr;
        }
        even.next = odd;
        return head;
    }
}
