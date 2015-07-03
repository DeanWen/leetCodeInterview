public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root, max);
        return max[0];
    }
    
    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        /*
        * 4 cases:
        * root, root + left, root + right, root + left + right
        */
        int ans = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max[0] = Math.max(max[0], Math.max(ans, root.val + left + right));
        
        return ans;
    }
}