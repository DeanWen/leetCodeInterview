//iterative
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }   
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ptr = root;
        while (!stack.isEmpty() || ptr != null) {
            if (ptr.right != null) {
                stack.push(ptr.right);
            }
            
            if (ptr.left != null) {
                ptr.right = ptr.left;
                ptr.left = null;
            }else if (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                ptr.right = temp;
            }
            
            ptr = ptr.right;
        }
    }
}
//recursion
public class Solution {
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right= root.right;
        flatten(root.left);
        flatten(right);
    }
}
