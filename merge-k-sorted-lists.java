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
        ListNode res = new ListNode(-1);
        while (!empty(lists)) {
            for (int i = 0; i < lists.length; i++) {
                findSmaller(lists, lists[i], res);
            }
        }
        return res.next;
    }
    
    public void findSmaller(ListNode[] lists, ListNode node, ListNode res) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != node && lists[i].val <= node.val) {
                res.next = lists[i];
                lists[i] = lists[i].next;
            }
        }
        res.next = node;
        node = node.next;
    }
    
    public boolean empty(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null) return false;
        return true;
    }
}
