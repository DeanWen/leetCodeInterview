public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	// use two pointers, slow - track the node before the dup nodes, 
    	// fast - to find the last node of dups.
        ListNode dummy = new ListNode(0);
        ListNode fast = head;
        ListNode slow = dummy;
        slow.next = fast;
        while(fast != null) {
        	while (fast.next != null && fast.val == fast.next.val) {
         		fast = fast.next;    //while loop to find the last node of the dups.
        	}
        	if (slow.next != fast) { //duplicates detected.
        		slow.next = fast.next; //remove the dups.
        		fast = slow.next;     //reposition the fast pointer.
        	} else { //no dup, move down both pointer.
        		slow = slow.next;
        		fast = fast.next;
        	}
        	
        }
        return dummy.next;
    } 
}
