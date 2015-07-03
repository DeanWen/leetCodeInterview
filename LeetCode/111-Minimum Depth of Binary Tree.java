public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }   
        
        //Divide & Conquer
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //if not balanced, return non-null substree height 
        if (left * right == 0) {
            return left + right + 1;
        }

        return Math.min(left, right) + 1;
    }
}