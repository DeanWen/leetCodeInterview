//Two Sum with no duplicate
public int[] towSum(int[] arr, int sum) {
	if (arr == null || arr.length == 0) {
		return null;
	}

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int i = 0; i < arr.length; i++) {
		map.put(arr[i], i + 1);
	}

	int[] res = new int[2];
	for (int i = 0; i < arr.length; i++) {
		if (map.contains(sum - arr[i])) {
			int index = map.get(sum - arr[i]);
			if (index == i) {
				continue;
			}

			res[0] = Math.min(index, i);
			res[1] = Math.max(index, i);
		}
	}

	return res;
}