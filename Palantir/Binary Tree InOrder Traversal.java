/*
*tree in-order traversal:
*/

//recursion
public static ArrayList<Integer> inOrder(TreeNode root) {
	ArrayList<Integer> result = new ArrayList<Integer>();

	if (root == null) return result;

	helper(result, root);

	System.out.print(Arrays.toString(result.toArray());
	return result;
}
public static void helper(ArrayList<Integer> result, TreeNode root) {
	if (root == null) return;

	helper(root.left);
	result.add(root.val);
	helper(root.right);
}

//iteration
public static ArrayList<Integer> inOrder(TreeNode root) {
	ArrayList<Integer> result = new ArrayList<Integer>();

	Stack<TreeNode> stack =new Stack<TreeNode>();  
    TreeNode node = root;  
    while(node != null || stack.size() > 0){  
        //left child exist  
        while(node!=null){  
            stack.push(node);  
            node = node.leftChild;  
        }  
        //stack is not empty
        if(stack.size() > 0){  
            node = stack.pop();  
            result.add(node.val);  
            node = node.rightChild;  
        }  
    }
     
    System.out.print(Arrays.toString(result.toArray()); 
}

