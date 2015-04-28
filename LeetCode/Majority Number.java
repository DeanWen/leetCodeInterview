public int majortiy(int[] nums) {
	if (nums == null || nums.length == 0) {
		return 0;
	}

	int count = 0;
	int obj = 0;

	for (int i = 0; i < nums.length; i++) {
		if (obj == nums[i]) {
			count++;
		}else {
			if (count == 0) {
				obj = nums[i];
				count = 1;
			}else {
				count--;
			}
		}
	}

	return obj;
}