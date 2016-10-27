/*
* Method: use two pointers, fast and slow start from head, fast 2X slow
* walk through the linked list to find the point that is in the circle (fast == slow)
* from the head to compare the node in the circle.
* find the start node of the circle (head == slow)
A bit explaination.
Provide the X is the length from head to the start point of circle and Y is the length of the circle. We know slow moves t, while fast moves 2t. They meet at K where is the length from the start point of the circle.
Then we have :

t = X + nY + K
2t = X + mY + K
, then we get

X+K  =  (m-2n)Y 
which means when they meet at K, the length from K to start point of the circle is just the X. At this moment, we use a head pointer to move by the same step (=1), and they must meet at the start point of the circle which we want.
X = (Y - K) + (m - 2n - 1)Y, (m - 2n - 1)Y is mulptile rounds of circle, assume m -2n -1 = 0
then X = Y - K
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
