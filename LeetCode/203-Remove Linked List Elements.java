/*
Time Complexity O(n)
Space Complexity O(1)
*/

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
    	if (head == null) {
    		return head;
    	}

    	ListNode dummyNode = new ListNode(0);
    	dummyNode.next = head;
    	ListNode pre = dummyNode;

    	while (head != null) {
    		if (head.val == val) {
    			pre.next = head.next;
    			head = head.next;
    		}else {
    			pre = head;
    			head = head.next;
    		}
    	}

    	return dummyNode.next;
    }
}