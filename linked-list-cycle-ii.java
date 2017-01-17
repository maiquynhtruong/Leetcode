/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	class Node {
		int val;
		Node next;
		Node(int v) {this.val = v; this.next = null;}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	}
	
	public static Node detectAndRemoveLoop(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			if (slow == fast) break;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (slow == fast) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}
	
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			// System.out.println("slow: " + slow.val + ", fast= " + fast.val);
			if (slow == fast) {
				// System.out.println("break");
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		// System.out.println("outside of while");
		if (slow == fast) {
			slow = head; fast = fast.next;
			// System.out.println("going for the start");
			while (slow != fast) {
				// System.out.println("slow: " + slow.val + ", fast= " + fast.val);
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		} else return null;
	}
}
