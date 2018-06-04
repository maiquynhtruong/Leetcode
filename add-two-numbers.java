/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, result = new ListNode(-1), dummy = result;
        int carryOver = 0, v1 = 0, v2 = 0, sum = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null) v1 = p1.val; else v1 = 0;
            if (p2 != null) v2 = p2.val; else v2 = 0;
            sum = v1 + v2 + carryOver;
            if (sum > 9) {
                carryOver = 1;
                sum = sum - 10;
            } else carryOver = 0;
            result.next = new ListNode(sum); 
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            result = result.next;
        }
        if (carryOver > 0) result.next = new ListNode(1);
        return dummy.next;
    }
}
