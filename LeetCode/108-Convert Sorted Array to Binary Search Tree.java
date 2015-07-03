public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        
        return build(num, 0, num.length - 1);
    }
    
    public TreeNode build (int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int middle = left + (right - left) / 2;
        TreeNode node = new TreeNode(num[middle]);
        node.left = build(num, left, middle - 1);
        node.right = build(num, middle + 1, right);
        
        return node;
    }
}