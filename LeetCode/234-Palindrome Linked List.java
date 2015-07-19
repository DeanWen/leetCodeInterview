/*
Main Idea
Using fast and slow pointer
find the middle
reverse the head - middle
compare slow and fast
*/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            //Using fast-slow pointer to get the middle node
            fast = fast.next.next;
            //reverse the nodes between head and the middle node
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        ListNode left = prev;
        ListNode right = slow;
        //list is odd, skip the middle node
        if(fast != null) {
            right = right.next;
        }
        
        while(true){
            if(right == null && left == null) return true;
            if(right == null || left == null) return false;
            if(right.val == left.val){
                right = right.next;
                left = left.next;
            }else {
                return false;
            }
        }
    }
}