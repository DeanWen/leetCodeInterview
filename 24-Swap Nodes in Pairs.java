public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = new ListNode(0);
        ListNode dummy = curr;
        curr.next = head;
        while (curr.next != null && curr.next.next != null) {
            curr.next = swap (curr.next, curr.next.next);
            curr = curr.next.next;
        }
        
        return dummy.next;
    }
    
    private ListNode swap (ListNode left, ListNode right) {
        left.next = right.next;
        right.next = left;      
        return right;
    }
}