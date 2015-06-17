//Validate BT is BST

public boolean isValidBST(TreeNode root) {
	//set upper bond and lower bond
    return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

private boolean isValidBSTHelper(TreeNode root, int min, int max) {
    if(root == null) {
        return true;
    }

    if(min != Integer.MIN_VALUE && root.val <= min) {
        return false;
    }

    if(max != Integer.MAX_VALUE && root.val >= max) { 
        return false;
    }
        
    return isValidBSTHelper(root.left, min, root.val) && 
    	   isValidBSTHelper(root.right, root.val, max);
}