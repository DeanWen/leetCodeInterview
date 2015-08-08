
public class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            if (current != null){
                current = current.left;
            }else {
                break;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode current = node;
        if(current.right != null) {
            current = current.right;
            while (current != null) {
                stack.push(current);
                if (current.left != null) {
                    current = current.left;
                }else {
                    break;
                }
            }
        }
        
        return node.val;
    }
}