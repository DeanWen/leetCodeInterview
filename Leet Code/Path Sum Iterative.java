/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null && node.val == sum) {
                return true;
            }
            if (node.left != null) {
                node.left.val += node.val;
                stack.push(node.left);
            }
            if (node.right != null) {
                node.right.val += node.val;
                stack.push(node.right);
            }
        }
        
        return false;
    }
}