public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int diff = Math.abs(lenA - lenB);
        
        while (diff > 0) {
            if(lenA > lenB) {
                headA = headA.next;  
            }else {
                headB = headB.next;
            }
            diff--;
        }
        
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    public int getLen (ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        return count;
    }
}