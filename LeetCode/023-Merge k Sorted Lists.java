public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return mergeSort(lists, 0 , lists.length - 1);
    }
    
    public ListNode mergeSort(ListNode[] lists, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            ListNode left = mergeSort(lists, low, mid);
            ListNode right = mergeSort(lists, mid + 1, high);
            return merge(left, right);
        }
        return lists[low];
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
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
        
        return dummy.next;
    }
}