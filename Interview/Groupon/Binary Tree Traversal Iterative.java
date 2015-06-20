public class Solution {
	public class TreeNode {
		int val;
     	TreeNode left;
     	TreeNode right;
     	TreeNode(int x) { val = x; }
 	}
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode p = root;

		while(!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			}else {
				TreeNode t = stack.pop();
				list.add(t.val);
				t = t.right;
			}
		}

		return list;
	}

	public ArrayList<Integer> preTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			list.add(n.val);

			if (n.left != null) {
				stack.push(n.left);
			}

			if (n.right != null) {
				stack.push(n.right);
			}
		}

		return list;
	}

	public ArrayList<Integer> postTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root);

		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			
			// go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				}else if(curr.right != null) {
					stack.push(curr.right);
				}else {
					stack.pop();
					list.add(curr.val);
				}

			//go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
			}else if (curr.left == prev){
				if (curr.right != null) {
					stack.push(curr.right);
				}else {
					stack.pop();
					list.add(curr.val);
				}
			//go up the tree from right node 
            //after coming back from right node, process parent node and pop stack.
			}else if (curr.right == prev){
				stack.pop();
				list.add(curr.val);
			}

			prev = curr;
		}

		return list;
	}
}