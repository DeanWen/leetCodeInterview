/**
*Thoughts:
*   Firstly, we need to find the middle of the LL
*   Secondly, reverse the second part of LL
*   Thirdly, merge two parts of the LL
*Key Points:
*   Must know 1. find the middle of LL
*             2. Reverse LL
*             3. Merge two LL
*/
public class Solution {
    public void reorderList(ListNode head) {
        /*
        *  corner case check
        *  if only one node in LL
        *  no need to reorder
        */
        if (head == null || head.next == null) {
            return;
        }
        
        /*
        * find the middle of the LL
        * using two pointers: slow and fast
        */
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            //condition means fast.next.next = null
            //if there odd numbers of nodes in LL
            //slow still need to move one more step
        	slow = slow.next;
        }
        
        /*
        *template of reverse LL (Must Remember!!)
        */
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        /*
        *template of merge two LLs (Must Remember!!)
        */
        ListNode temp=null;
        ListNode temp2=null;
        ListNode current1=head;
        ListNode current2=prev;
        while (current2 != slow) {
	        temp = current1.next;
	        current1.next = current2;
	        temp2 = current2.next;
	        current2.next = temp;
	        current2 = temp2;
	        current1 = current1.next.next;
        }
    }
}