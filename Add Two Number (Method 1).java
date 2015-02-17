/**
 * Add Two numbers Method 1
 * Case 1  l1 != null && l2 != null
 * Case 2  l1 != null
 * Case 3  l2 != null 
 * Remember to take care of the last carry-on
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) 
            return null;
            
        ListNode result = new ListNode(0);
        ListNode dummyNode = result;
        int carry = 0;
        
        //case 1
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                result.next = new ListNode(sum - 10);
                carry = 1;
            }else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        
        //case 2
        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum >= 10) {
                result.next = new ListNode(sum - 10);
                carry = 1;
            }else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            
            l1 = l1.next;
            result = result.next;
        }
        
        //case 3
        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum >= 10) {
                result.next = new ListNode(sum - 10);
                carry = 1;
            }else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            
            l2 = l2.next;
            result = result.next;
        }
        
        //last carry on
        if (carry == 1) {
            result.next = new ListNode(carry);
        }
        
        return dummyNode.next;
    }
}