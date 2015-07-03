//This solution also goes to the left subtree first. 
//If the violation occurs close to the root but on the right subtree, 
//the method still cost O(n).

public class Solution {
    public boolean isValidBST(TreeNode root) {
    	//set upper bond and lower bond
        //set null to avoid input as Integer.MAX || Integer.MIN
        //[2147483647,2147483647]
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        
        if (min != null && root.val <= min) {
            return false;
        }
        
        if (max != null && root.val >= max) {
            return false;
        }
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}