public class Node {
	int data;
	Node left;
	Node right;
	Node(int x) {
		data = x;
		left = null;
		right = null;
	}
}

public void delete(int toDelete) {
	root = delete(root, toDelete);
}

private Node delete(Node p, int toDelete) {
	if (p == null)  {
		throw new RuntimeException("cannot delete.");
	} else if (p.data > toDelete) {
		p.left = delete (p.left, toDelete);
	} else if (p.data < toDelete) {
		p.right = delete (p.right, toDelete);
	} else {
		if (p.left == null) {
	 		return p.right;
	 	} else if (p.right == null) {
	 		return p.left;
		} else {
		// get data from the rightmost node in the left subtree
		    p.data = retrieveData(p.left);
		// delete the rightmost node in the left subtree
		    p.left = delete(p.left, p.data);
		}
	}
  return p;
}

private int retrieveData(Node p) {
	while (p.right != null) {
		p = p.right;
	}

	return p.data;
}