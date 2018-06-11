/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	
	// merge sort style
	public static void main (String[] args) throws java.lang.Exception
	{
		return mergeLists(lists, 0, lists.length-1);
	}

	public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val > l2.val) {
			l2.next = mergeTwoLists(l1.next, l2);
			return l2;
		} else {
			l1.next = mergeTwoLists(l1, l2.next);
			return l1;
		}
	}
	
	public static ListNode mergeLists(ListNode[] lists, int left, int right) {
		if (left > right) return null;
		if (left == right) return lists[left];
		int len = right - left + 1;
		return mergeTwoLists(mergeLists(lists, 0, len/2), mergeLists(lists, len/2+1, len));
	}
	
	// using priority queue
	public ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<ListNode> p = new PriorityQueue<lists.size(), new Comparator<ListNode>() {
			public int compareTo(ListNode other) {
				return this.val - other.val;
			}
		}
		ListNode head = new ListNode(0);
		ListNode dummy = head;
		for (ListNode listNode : lists) {
			if (listNode != null) p.add(listNode);
		}
		while (!p.isEmpty()) {
			dummy.next = p.poll();
			dummy = dummy.next;
			
			if (dummy.next != null) 
				p.add(dummy.next);
		}
		return head.next;
	}
	
	// for loop finding smallest ListNode in an array with no priority queue
	
	class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		ListNode dummy = new ListNode(Integer.MAX_VALUE), cur = dummy;
		while (cur != null) {
		    ListNode smallest = dummy;
		    int index = 0;
		    for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null && smallest.val > lists[i].val) {
			    smallest = lists[i];
			    index = i;
			}
		    }
		    if (smallest != dummy) cur.next = smallest; 
		    cur = cur.next;
		    if (lists[index] != null) lists[index] = lists[index].next;
		}
		return dummy.next;
	    }
	}
}
