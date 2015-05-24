public boolean isSymmetric(TreeNode root) {
    if(root == null)
        return true;
    if(root.left == null && root.right == null)
        return true;
    if(root.left == null || root.right == null)
        return false;
    LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
    LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
    q1.add(root.left);
    q2.add(root.right);
    while(!q1.isEmpty() && !q2.isEmpty()){
        TreeNode n1 = q1.poll();
        TreeNode n2 = q2.poll();
        
        if(n1.val != n2.val)
            return false;
        if((n1.left == null && n2.right != null) || (n1.left != null && n2.right == null))
            return false;
        if((n1.right == null && n2.left != null) || (n1.right != null && n2.left == null))
            return false;
        
        if(n1.left != null && n2.right != null){
            q1.add(n1.left);
            q2.add(n2.right);
        }
        
        if(n1.right != null && n2.left != null){
            q1.add(n1.right);
            q2.add(n2.left);
        }            
    }
    return true;
}