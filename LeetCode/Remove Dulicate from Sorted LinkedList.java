/*
* sulution:
*/

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode dummyNode = start;
        
        while(head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if(start.next == head) {
                start = start.next;
            }else {
                start.next = head.next;
            }
            head = head.next;
        }

        return dummyNode.next;
    }
}