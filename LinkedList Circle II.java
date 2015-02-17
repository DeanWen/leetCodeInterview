/*
* Method: use two pointers, fast and slow start from head, fast 2X slow
* walk through the linked list to find the point that is in the circle (fast == slow)
* from the head to compare the node in the circle.
* find the start node of the circle (head == circle)
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
    	if (head == null) {
    		return null;
    	}

    	ListNode fast = head;
    	ListNode slow = head;

    	do {
    		if (fast.next || fast.next.next == null) {
    			return null;
    		}
    		fast = fast.next.next;
    		slow = slow.next;
    	}while (fast != slow);

    	while (head != slow) {
    		head = head.next;
    		slow = slow.next;
    	}

    	return head;
    }
}