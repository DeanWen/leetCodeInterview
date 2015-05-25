import java.util.*;

public class TeneryTree {
	public static void main(String[] args) {
		String test = "a?b?c:d:e";
		inorderTraversal(BuildTeneryTree(test));
	}

	public static Node BuildTeneryTree(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		
		return helper(s, 0, s.length() - 1);
	}

	public static Node helper(String s, int start, int end) {
		if (start == end) {
			return new Node(String.valueOf(s.charAt(start)));
		}

		Node root = new Node(String.valueOf(s.charAt(start)));
		Stack<Integer> stack = new Stack<Integer>();
		int step = start;
		int mark = 0;
		while (step <= end) {
			if (s.charAt(step) == '?') {
				stack.push(step);
			} else if (s.charAt(step) == ':') {
				mark = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
			}
			step++;
		}

		root.left = helper(s, mark + 1, step - 1);
		root.right = helper(s, step + 1, end);
		return root;
	}

	public static void inorderTraversal(Node root) {
		ArrayList<String> result = new ArrayList<String>();
		if (root == null) {
			return;
		}
		helper(root, result);
		for (String s : result) {
			System.out.print(s + " ");
		}
	}

	public static void helper(Node root, ArrayList<String> result) {
		if (root == null) {
			return;
		}
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}

	public static class Node {
		String val;
		Node left;
		Node right;
		Node(String v) {
			val = v;
			left = null;
			right = null;
		}
	}
}