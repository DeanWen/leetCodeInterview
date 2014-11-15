/*
*Given an unsorted array of integers, 
*return true if the array contains any duplicates 
*and false if it does not contain any duplicates. 
*You do not have to identify the duplicate value
*/

public boolean isDuplicate(int[] array) {
	if (array == null || array.length == 0) {
		return false;
	}

	List<Integer> list = new ArrayList<Integer>();
	for (int i = 0; i < array.length; i++) {
		if (!list.contains(array[i])) {
			list.add(array[i]);
		}else {
			return true;
		}
	}

	return false;
}

/*
*
*Given an array of integers and an integer k. It
*should return true if and only if there are two distinct indices i and j into
*the array such that arr[i] = arr[j] and the difference between i and j is at
*most k.
*	[1, 0, 2, 1] k = 2 -- false
*	[1, 0, 2, 1] k = 3 — true
*/

public static boolean isDuplicate1(int[] array, int k) {
	if (array == null || array.length == 0 || k == 0) {
		return false;
	}

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int index = 0; index < array.length; index++) {
		if (!map.containsKey(array[index])) {
			map.put(array[index], index);
		}else {
			int prevIndex = map.get(array[index]);
			if (index - prevIndex >= k) {
				return true;
			}
		}
	}

	return false;
}