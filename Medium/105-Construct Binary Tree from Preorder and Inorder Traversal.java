public class Solution {
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, 
                               preorder, 0, preorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, 
                     int[] preorder, int preStart, int preEnd) {
        if (inStart > end) {
            return null;
        }

        TreeNode root = preorder[preStart];
        int position = findRoot(inorder, inStart, inEnd, root.val);

        root.left = buildTreeHelper(inorder, inStart, position - 1,
            preorder, position, preStart + position - inStart);
        root.right = buildTreeHelper(inorder, position + 1, inEnd
            preorder, preEnd + position - inEnd + 1, preEnd);
    }
    
    private int findRoot(int[] array, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}