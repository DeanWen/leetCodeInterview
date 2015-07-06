//recursion
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}

//iterative post-order
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null) {
            swap(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            node = node.right;
            if(node == null && !stack.isEmpty()) {
                node = stack.pop();
            }
        }
        
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}