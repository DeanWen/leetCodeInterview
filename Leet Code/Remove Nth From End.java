public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode slow = dummyNode;
        ListNode fast = dummyNode.next;
        int counter = 0;
        int amount = 1;

        while (fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	counter = counter + 1;
        }

        if (fast.next == null) {
        	amount = counter * 2 + 1;
        }else if (fast.next.next == null) {
        	amount = counter * 2 + 2;
        }

        int position = amount - n;

        if (position == 0) {
        	dummyNode.next = head.next;
        }else if (position == amount){
        	return dummyNode.next;
        }else{
        	while(counter < amount) {
        		if (counter == position){
        			slow.next = slow.next.next;
        			break;
        		}else if (counter > position){
        			counter = 0;//reset the counter
        			slow = head;
        		}else {
        			slow = slow.next;
        		}
        		counter = counter + 1;
        	}
        }
        return dummyNode.next;   
    }
}