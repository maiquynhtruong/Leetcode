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

/** Another way **/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1), tummy = new ListNode(-1);
        dummy.next = head; tummy.next = head.next;
        ListNode odd = dummy, even = tummy, cur = head;
        while (cur != null) {
            
            odd.next = cur;
            odd = odd.next;
            cur = cur.next;
            even.next = cur;
            if (cur == null) break;
            even = even.next;
            cur = cur.next;
        }
        odd.next = tummy.next;
        return dummy.next;
    }
}
