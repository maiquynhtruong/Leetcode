/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1), moreHead = new ListNode(-1), less = lessHead, more = moreHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                more.next = cur;
                more = more.next;
            }
            cur = cur.next;
        }
        more.next = null;
        less.next = moreHead.next;
        return lessHead.next;
    }
}
