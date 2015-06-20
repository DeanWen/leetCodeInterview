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

	HashSet<Integer> set = new HashSet<Integer>();
	//O(n)
	for (int i = 0; i < array.length; i++) {
		//O(1)
		if (!set.contains(array[i])) {
			set.add(array[i]);
		}else {
			return true;
		}
	}

	return false;
}

	public static boolean isDuplicate(int arr[], int size){
	  for (int i = 0; i < size; i++) {
	    if (arr[Math.abs(arr[i])] >= 0) {
	    	arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
	    }else {
	    	System.out.print(Math.abs(arr[i]));
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
	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	//O(n)
	for (int index = 0; index < array.length; index++) {
		//O(1)
		if (!map.containsKey(array[index])) {
			map.put(array[index], index);
		}else {
			int prevIndex = map.get(array[index]);
			if (index - prevIndex <= k) {
				return true;
			} else {
				map.put(array[index], index);
			}
		}
	}

	return false;
}

public static boolean isDuplicate(int[] array, int k) {
	if (array == null || array.length == 0 || k == 0) {
		return false;
	}
	
	//O(n)
	final int capacity = k;
	Map<Integer, Integer> lmap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
	    @Override
	    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	    return size() > capacity;
	    }
	};
     
	//O(n)
	for (int index = 0; index < array.length; index++) {
		//O(1)
		if (!lmap.containsKey(array[index])) {
			lmap.put(array[index], index);
		}else {
			int prevIndex = lmap.get(array[index]);
			if (index - prevIndex <= k) {
				return true;
			}else {
				map.put(array[index], index);
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
*	[1, 5, 2, 9] k = 2  d = 1 (2 - 1 = a[0]-a[2] <= 2) -- true
*	[1, 5, 9, 2] k = 2  d = 1 (2 - 1 = a[0]-a[3] > 2) -- false
*/
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0 || k <= 0) {
        return false;
    }

    TreeSet<Integer> values = new TreeSet<>();
    for (int ind = 0; ind < nums.length; ind++) {

        Integer floor = values.floor(nums[ind] + t);//upper bond
        Integer ceil = values.ceiling(nums[ind] - t);//lower bond
        
        if ((floor != null && floor >= nums[ind])
                || (ceil != null && ceil <= nums[ind])) {
            return true;
        }

        values.add(nums[ind]);
        if (ind >= k) {
            values.remove(nums[ind - k]);
        }
    }

    return false;
}