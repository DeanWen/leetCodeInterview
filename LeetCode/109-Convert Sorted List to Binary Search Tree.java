public class Solution {
    private static ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.head = head;
        
        // get list length
        int len = 0;
        ListNode ln = head;
        while(ln != null){
            len++;
            ln = ln.next;
        }
        
        return helper(0, len - 1);
    }
    
    public TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        // build left sub tree
        TreeNode left = helper(start, mid - 1);
        // build root node
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        // move to next node to build right sub tree
        head = head.next;
        root.right = helper(mid + 1, end);
         
        return root;
    }
}