import java.util.*;
public class BSTInRange {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
			left = null;
			right = null;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		
		int lowerBond = 2;
		int upperBond = 6;
		
		List<Integer> res = findNodesInRange(root, lowerBond, upperBond);
		System.out.println(res.toString());
	}
	
	/*
	* Time Complexity : O(logn + k) n is total nodes, k is the range
	* Find the first element in the range should be logn, then at most k
	* Space Complexity : O(1)
	*/
	public static List<Integer> findNodesInRange (TreeNode root, int lowerBond, int upperBond) {
		List<Integer> res = new LinkedList<Integer>();
		if (root == null) {
			return res;
		}

		helper(root, lowerBond, upperBond, res);
		return res;
	}
	
	private static void helper (TreeNode node, int lowerBond, int upperBond, List<Integer> res) {
		if (node == null) {
			return;
		}

		if (node.val >= lowerBond && node.val <= upperBond) {
			res.add(node.val);
			helper(node.left, lowerBond, node.val, res);
			helper(node.right, node.val, upperBond, res);
		}else if (node.val < lowerBond) {
			helper(node.right, node.val, upperBond, res);
		}else {
			helper(node.left, lowerBond, node.val, res);
		}
	}
}