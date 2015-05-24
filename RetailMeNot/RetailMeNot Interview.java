/*
Find All Valid Cut of Prime Number in an array
Divide & Conquer Questions
*/
public ArrayList<Integer> allValidCut (int[] array) {
	if (array == null || array.length == 0) {
		return null;
	}

	int start = 0;
	int end = 0;
	while (end < array.length) {
		if () {
			
		}
	}
}

public ArrayList<Integer> helper (int[] array, int start) {
	int start = start;

	if (isPrime(array, 0, start)) {
		
	}
}



/*
Consider you wanna fabricate a anonymous letter whose words and abcdef...
are cut off from a news paper. So the question is, if this news paper 
could compose all the alphabetics you need. 
Write a method in JAVA that returns boolean type. And answer the average speed
*/

public boolean isEnoughAlpha(String newsPaper, String letter) {
	if (newsPaper == null || newsPaper.length() == 0) {
		return false;
	}

	HashSet<Character> set = new HashSet<Character>();
	for (int i = 0; i < newsPaper.length(); i++) {
		if (!set.contains(newsPaper.charAt(i))) {
			set.add(newsPaper.charAt(i));
		}
	}

	for (int i = 0; i < letter.letter(); i++) {
		if (!set.contains(letter.charAt(i))) {
			return false;
		}
	}

	return true;
}

/*
The question had to do with sorting through a array of deals 
to determine the most commonly used words.
*/

HashMap<String, Integer> map = new HashMap<String, Integer>();
String = words;
Integer = appearing times;

/*
you're a guard of a prison, you want to keep an eye 
on the most dangerous prisoner. 
Each prisoner has a danger rank of his own and a group of friends 
(who also have danger ranks). 
You'll need to go through the prison and find out the 
prisoner who has the highest danger rank (his own + all his friends).
*/
public class Prisoner {
	int rank;
	List<Prisoner> friends;
	Prisoner() {
		rank = 0;
		friends = null;
	}
}

public Prisoner findMostDangerous (List<Prisoner> prison) {
	if (prison == null || prison.size() == 0) {
		return null;
	}

	List<Integer> rankList = new ArrayList<Integer>();
	int max = 0;
	for (int i = 0; i < prison.size(); i++) {
		Prisoner curr = prison.get(i);
		int currRank = curr.rank;
		for (int j = 0; j < curr.friends.size(); j++) {
			currRank += curr.friends.get(i).rank;
		}
		max = Math.max(currRank, max);
		rankList.add(currRank);
	}

	int maxLocation = 0;
	for (int i = 0; i < rankList.size(); i++) {
		if (rankList.get(i) == max) {
			maxLocation = i;
		}
	}

	return prison.get(maxLocation);
}

/*
Get the entries happened more than two times in a list
*/
public List<String> findMoreThanTwo(List<String> entries) {
	if (entries == null || entries.size() == 0) {
		return null;
	}

	//store all appereance times in a hashmap
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	for (int i = 0; i < entries.size(); i++) {
		if (!map.containsKey(entries.get(i))) {
			map.put(entries.get(i), 1);
		}else {
			map.put(entries.get(i), map.get(entries.get(i)) + 1);
		}
	}

	ArrayList<String> result = new ArrayList<String>(); 
	for (int i = entries.size() - 1; i > 0; i--) {
		if (map.get(entries.get(i)) > 2) {
			result.add(entries.get(i));
		}
	}

	return result;
}

/*
You have a list of tv episodes in the order 
they were aired (most recent last in the list). 
Develop an algorithm to determine which episode should be aired next, 
based on which episode was aired the least recently
*/
/*
Given a one-directional list of movie titles in order of 
how long ago you watched them (there may be duplicates), 
find the LEAST-recently watched singleton movie title.
*/
public String findLesatRecentSingleton(List<String> titles) {
	if (titles == null || titles.size() == 0) {
		return null;
	}

	//store all appereance times in a hashmap
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	for (int i = 0; i < titles.size(); i++) {
		if (!map.containsKey(titles.get(i))) {
			map.put(titles.get(i), 1);
		}else {
			map.put(titles.get(i), map.get(titles.get(i)) + 1);
		}
	}

	//scan again to find LEAST-recently 
	for (int i = titles.size() - 1; i > 0; i--) {
		if (map.get(titles.get(i)) == 1) {
			return titles.get(i);
		}
	}
}

/*
given an array of strings,
return the FIRST one which appears only once in the array
*/
public String findSingleOne(String[] array) {
	if (array == null || arrary.length == 0) {
		return null;
	}

	//store all appereance times in a hashmap
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	for (int i = 0; i < array.length; i++) {
		if (!map.containsKey(array[i])) {
			map.put(array[i], 1);
		}else {
			map.put(array[i], map.get(array[i]) + 1);
		}
	}

	//scan again to find first one appearing only once
	for (int i = 0; i < array.length; i++) {
		if (map.get(array[i]) == 1) {
			return array[i];
		}
	}
}

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

