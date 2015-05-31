/*
*   Time Complexity : O(n)
*   Space Complexity : O(n)
*/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode node = dummyNode;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        if (l1 != null) {
            node.next = l1;
        }else {
            node.next = l2;
        }
        
        return dummyNode.next;
    }
}