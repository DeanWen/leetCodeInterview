public class Solution {
	public static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int v) {
			value = v;
			left = null;
			right = null;
			parent = null;
		}
	}

	//Provide Parent Pointer
	public static TreeNode nextNode(TreeNode node){
		if (node.right != null) {
			TreeNode curr = node.right;
			while (curr.left != null) {
				curr = curr.left;
			}
			return curr;
		}else {
			TreeNode curr = node;
			while (curr.parent != null && curr == curr.parent.right) {
				curr = curr.parent;
			}
			return curr.parent;
		} 
	}
	
	//no parent pointer
	public static TreeNode nextNode (TreeNode root, TreeNode node) {
		if (node.right != null) {
			TreeNode curr = node.right;
			while (curr.left != null) {
				curr = curr.left;
			}
			return curr;
		} else {
			TreeNode curr = root;
			TreeNode parent = null;
			while (curr.val != node.val) {
				if (curr.val > node.val) {
					parent = curr;
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			}
			return parent;
		}
	}
}