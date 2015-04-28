public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }
        
        ListNode temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        
        if (n >= count) {
            n = n % count;
        }
        
        if (n == 0) {
            return head;
        }
        
        ListNode temp2 = head;
        for (int i = 0; i < count - n - 1; i++) {
           temp2 = temp2.next;
        }
        
        ListNode newHead;
        if (temp2.next == null) {
            newHead = temp2;
            temp2.next = head;
            while(head.next != temp2) {
                head = head.next;
            }
            head.next = null;
        }else {
            newHead = temp2.next;
            temp2.next = null;
            
            ListNode temp3 = newHead;
            while(temp3.next != null) {
                temp3 = temp3.next;
            }
            temp3.next = head;
        }
        
        return newHead;
    }
}