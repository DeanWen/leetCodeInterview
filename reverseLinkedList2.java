//Reverse a linked list from m to n
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        tail = head;
        int step = n - m;
        while(m > 0){
            tail = tail.next;
            m = m - 1;
        }
        
        ListNode prev,current,next;
        prev = null;
        current = tail;
        next = current.next;
        while(step > 0 && next != null) {
            prev = current;
            current = next;
            next = prev;
            step = step - 1;
        }

        tail.next = prev;

        return dummyNode.next; 
    }
}