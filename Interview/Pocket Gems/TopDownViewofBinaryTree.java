// Java program to print top view of Binary tree
// Reference : http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
import java.util.*;
public class TopDownViewofBinaryTree {
	public static class TreeNode {
		int key;
		TreeNode left, right;
		public TreeNode(int key) {
			this.key = key;
			left = right = null;
		}
	}

	// A class to represent a queue item. The queue is used to do Level
	// order traversal. Every Queue item contains node and horizontal
	// distance of node from root
	public static class QItem {
		TreeNode node;
		int hd;
		public QItem(TreeNode n, int h) {
			node = n;
			hd = h;
		}
	}

	// Class for a Binary Tree
	public static class Tree {
		TreeNode root;
		public Tree() {
			root = null;
		}
		public Tree(TreeNode n) {
			root = n;
		}

		public void printTopView() {
			// base case
			if (root == null) {
				return;
			}

			// Creates an empty hashset
			HashSet<Integer> set = new HashSet<>();

			// Create a queue and add root to it
			Queue<QItem> Q = new LinkedList<QItem>();
			Q.add(new QItem(root, 0)); // Horizontal distance of root is 0

			// Standard BFS or level order traversal loop
			while (!Q.isEmpty()) {
				// Remove the front item and get its details
				QItem qi = Q.remove();
				int hd = qi.hd;
				TreeNode n = qi.node;

				// If this is the first node at its horizontal distance,
				// then this node is in top view
				if (!set.contains(hd)) {
					set.add(hd);
					System.out.print(n.key + " ");
				}

				// Enqueue left and right children of current node
				if (n.left != null)
					Q.add(new QItem(n.left, hd - 1));
				if (n.right != null)
					Q.add(new QItem(n.right, hd + 1));
			}
		}
	}
	
	public static void main(String[] args){
        /* Create following Binary Tree
             1
           /  \
          2    3
           \
            4
             \
              5
               \
                6*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        Tree t = new Tree(root);
        System.out.println("Following are nodes in top view of Binary Tree");
        t.printTopView();
    }
}
