//Reverse a linked list from m to n
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        int i = 0;
        while (head != null) {
            if (i + 1 < m) {
                prev = prev.next;
            }
            if (i == n) {
                break;
            }
            head = head.next;
            i++;
        }
        
        prev = reverse(prev, head);
        return dummy.next;
    }
    
    private ListNode reverse(ListNode prev, ListNode end) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        while (curr != end) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }
}
