/*
Note:
    Given n will always be valid.
    Try to do this in one pass.
*/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null && head.next == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        // n is always valid
        //Move Forward N Steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        //the head needs to remove
        if (fast == null) {
            head = head.next;
            return head;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return head;
    }
}