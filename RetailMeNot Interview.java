/*
You have a list of tv episodes in the order 
they were aired (most recent last in the list). 
Develop an algorithm to determine which episode should be aired next, 
based on which episode was aired the least recently
*/
/*
Given a one-directional list of movie titles in order of 
how long ago you watched them (there may be duplicates), 
find the least-recently watched singleton movie title.
*/




/*
Consider you wanna fabricate a anonymous letter whose words and abcdef...
are cut off from a news paper. 
So the question is, if this news paper could compose all
the alphabetics you need. Write a method in JAVA that returns boolean type. 
And answer the average speed
*/

/*
you're a guard of a prison, you want to keep an eye 
on the most dangerous prisoner. 
Each prisoner has a danger rank of his own and a group of friends 
(who also have danger ranks). 
You'll need to go through the prison and find out the 
prisoner who has the highest danger rank (his own + all his friends).
*/

/*
Get the entries happened more than two times in a list
*/

/*
given an array of strings,
return the first one which appears only once in the array
*/

/*
The question had to do with sorting through a array of deals 
to determine the most commonly used words.
*/

/*
Given a binary tree, design an algorithm that does a level order 
traversal of the tree, where each level is printed out in the 
reverse order as the previous level.
*/

public void levelOrderTraversal (TreeNode root) {
	if (root == null) {
		throw new IllegalArgumentException("Invalid argument");
	}

	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	queue.offer(root);
	
	while(!queue.isEmpty()) {
		int size = queue.size();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		for (int i = 0; i < size; i++) {
			TreeNode node = queue.poll();
			list.add(node.val);
			if (result.size() % 2 != 0) {
				list.addFirst(list);
			}else {
				list.add(list);
			}
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		result.add(list);
	}

	//Print out level by level
	for (int i = 0; i < result.size(); i++) {
		for (int j = 0; j < result.get(i).size(); j++) {
			System.out.print(result.get(i).get(j));
			System.out.println();
		}
	}
}

