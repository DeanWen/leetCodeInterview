/*
* Tree is Binary Tree
*/
public Node findLCA (Node root, Node n1, Node n2) {
	int left = Math.min(n1.val, n2.val);
	int right = Math.max(n1.val, n2.val);

	Node parent = null;
	while (true) {
		//if root smaller than n1 n2, go right
		if (root.val < left) {
			parent = root;
			root = root.right;
		//if root greater than n1 n2, go left
		}else if (root.val > right) {
			parent = root;
			root = root.left;
		//if find either one, return parent
		}else if (root.val == left || root.val == right) {
			return parent;
		}else {
			return root;
		}
	}
}

/*
* Not BST just BT No Parent Pointer
*/

public Node findLCA (Node root, Node n1, Node n2) {
	if (root == null) {
		return null;
	}
	if (root == n1 || root == n2) {
		return root;
	}

	Node left = findLCA(root.left, n1, n2);
	Node right = findLCA(root.right, n1, n2);

	if (left != null && right != null) {
		return root;
	}else if (left != null) {
		return left;
	}else if (right != null) {
		return right;
	}else {
		return null;
	}
}


/*
* BT With Parent Pointer
*/

public Node findLCA (Node n1, Node n2) {
	List<Node> l1 = helper(n1);
	List<Node> l1 = helper(n1);

	int i = l1.size() - 1;
	int j = l2.size() - 1;
	while (i >= 0 && j >= 0) {
		if (l1.get(i) != l2.get(i)) {
			return l1.get(i).parent;
		}
		i--;
		j--;
	}

	return l1.get(i + 1);
}

private List<Node> helper (Node n) {
	List<Node> list = new ArrayList<Node>();
	while (n != null) {
		list.add(n);
		n = n.parent;
	}
	return list;
}