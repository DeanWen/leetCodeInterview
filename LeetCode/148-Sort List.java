public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //find the mid node
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //mergeSort Left and right respectively
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = head;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail;
        tail = dummyNode;
        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        if(head1 != null){
            tail.next = head1;
        }else{
            tail.next = head2;
        }
        
        return dummyNode.next;
    }
}