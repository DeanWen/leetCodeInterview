//Time Complexity : O(n)
//Two Pointer needle cross all smaller and larger
//concancate these two
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        
        ListNode small = new ListNode(0);
        ListNode dummy1 = small;
        ListNode large = new ListNode(0);
        ListNode dummy2 = large;
        
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        
        large.next = null;
        small.next = dummy2.next;
        return dummy1.next;
    }
}