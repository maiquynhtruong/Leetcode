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
	public static void main (String[] args) throws java.lang.Exception
	{
		
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
	
	public static ListNode mergeLists(ListNode[] left, ListNode[] right) {
		if (left.length == 1 && right.length == 1) 
			return mergeTwoLists(left[0], right[0]);
		else {
			int len = left.length + right.length;
			ListNode leftNode = mergeLists();
			ListNode rightNode = mergeLists();
			return mergeTwoLists(leftNode, rightNode);
		}
	}
}
