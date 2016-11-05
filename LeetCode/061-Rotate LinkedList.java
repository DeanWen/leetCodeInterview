public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
	    ListNode fast = head;
	    ListNode slow = head;
	    for(int i = 1; i <= k; i++){
		    fast = fast.next;
		    if(fast == null) {
		        fast = head;
		        k = k % i;
		        i = 0;
		    }
	    }
	    while(fast.next != null){
		    fast = fast.next;
		    slow = slow.next;
	    }
		
	    fast.next = head;
	    ListNode newHead = slow.next;
	    slow.next = null;
        return newHead;
    }
}
