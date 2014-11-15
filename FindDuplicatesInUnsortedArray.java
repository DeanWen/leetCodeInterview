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
	//O(n)
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

public static boolean isDuplicate(int[] array, int k) {
	if (array == null || array.length == 0 || k == 0) {
		return false;
	}
	//O(n)
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

/*
*Given an unsorted list of integers, 
*return true if the list contains any fuzzy duplicates within k indices of each element. 
*A fuzzy duplicate is another integer within d of the original integer. 
*Example: 
*	[1, 0, 2, 1] k = 3  d = 4 (2 - 1 = 1 < 4) -- true
*	[1, 0, 2, 7] k = 3  d = 4 (7 - 1 = 6 > 4) -- false
*/
public static boolean isDuplicate(int[] array, int k, int d) {
	if (array == null || array.length == 0 || k == 0) {
		return false;
	}
	//O(k*n)
	for (int index = 0; index < array.length; index++) {
		int count = index > k ? k : index;
		while (count-- > 0) {
			if (array[index] - array[index - count] <= d) {
				return true;
			}
		}
	}

	return false;
}