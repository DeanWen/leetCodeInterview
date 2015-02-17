public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
    	    return false;
    	}
    	
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode.next;
        ListNode fast = dummyNode.next.next;

        while (fast.next != null && fast.next.next != null) {
            if (fast == slow) {
        		return true;
        	}
    		slow = slow.next;
    		fast = fast.next.next;
        }
        
        return false;
    }
}