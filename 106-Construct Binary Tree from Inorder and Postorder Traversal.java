public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, 
                               postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, 
                     int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int position = findRoot(inorder, inStart, inEnd, root.val);
        root.left = buildTreeHelper(inorder, inStart, position - 1, 
                    postorder, postStart, postStart + position - inStart - 1);
        root.right = buildTreeHelper(inorder, position + 1, inEnd,
                     postorder, postStart + position - inStart, postEnd - 1);
        
        return root;
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