public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        helper(root, result);
        
        return result;
        
    }
    
    public void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}