import java.util.*;
/*
Question 2
==========
Ex 1: "a?b:c"

         a
      b    c
      
Ex 2: "a?b?c:d:e"

         a
    b        d
  c   d

Ex 3: "a?b:c?d:e"

          a
    b            c
               d   e

class Node
{
  Node left, right;
  char value;
}

Write a function which, given a ternary expression string input, parses it into the correct tree and returns the root node of that tree.

Assumptions:
1. All inputs are valid ternary expressions.
2. Every node value is a single letter (alphabet), symbols include ? and : only.

Node parseExpression(String input);

*/
public class TeneryTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a?b:c?d?e:f:g";
		str = "a?b?c:d:e";
		str = "a?b:c?d:e";
		str = "a?b?d:e:c?f:g";
		inorderTraversal(BuildTeneryTree(str));
	}

	/*
	*	Iterative Version
	*/
	public static Node BuildTeneryTree(String str) {
		if (str == null || str.trim().length() == 0) {
			return null;
		}
		
		str = str.trim();
		
		Node root = new Node(str.charAt(0));
		Node cur = root;
		Stack<Node> stack = new Stack<>();
		
		for (int i = 1; i < str.length(); i = i + 2) {
			char c = str.charAt(i);
			
			if (c == '?') {
				cur.left = new Node(str.charAt(i + 1));
				stack.push(cur);
				cur = cur.left;
			} else {
				stack.peek().right = new Node(str.charAt(i + 1));
				cur = stack.pop().right;
			}
		}
		
		return root;
	}

	public static void inorderTraversal(Node root) {
	    ArrayList<Character> result = new ArrayList<Character>();
	    Node node = root;
	    Stack<Node> stack = new Stack<Node>();
	    
	    while (node != null || !stack.isEmpty()) {
	        if (node != null) {
	            stack.push(node);
	            node = node.left;
	        } else {
	            Node temp = stack.pop();
	            result.add(temp.val);
	            node = temp.right;
	        }
	    }
	    
		for (char s : result) {
			System.out.print(s);
		}
	}

	/*
	*	Recursion Version
	*/
	public static Node BuildTeneryTree(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		
		return helper(s, 0, s.length() - 1);
	}

	public static Node helper(String s, int start, int end) {
		if (start == end) {
			return new Node(s.charAt(start));
		}

		Node root = new Node(s.charAt(start));
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
		ArrayList<Character> result = new ArrayList<Character>();
		if (root == null) {
			return;
		}
		helper(root, result);
		for (Character s : result) {
			System.out.print(s + " ");
		}
	}

	public static void helper(Node root, ArrayList<Character> result) {
		if (root == null) {
			return;
		}
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}

	public static class Node {
		char val;
		Node left;
		Node right;
		Node(char v) {
			val = v;
			left = null;
			right = null;
		}
	}
}