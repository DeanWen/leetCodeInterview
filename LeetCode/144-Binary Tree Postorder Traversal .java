/**
*Use Binary Tree PreOder
*Key point using Recursion || while loop
*letf -> right -> root
*use helper fuctions to do recursive
*/
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            // must return result, even if empty.
            //since if tree is empty, arraylist is also empty
            return result;
        }
        //start from root to do recursion
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return; // if no more leaves, stop recursion
        }
        //post order is left, right, root
        helper(root.left, result);//go through left
        helper(root.right, result);//go through right
        result.add(root.val);//go through root      

    }
}