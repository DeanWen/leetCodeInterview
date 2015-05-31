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

/*
Given an array of integers and a number k, 
the majority number is the number that occurs
more than 1/k of the size of the array. Find it.

Example
For [3,1,2,3,2,3,3,4,4,4] and k = 3, return 3

Challenge
O(n) time and O(k) extra space
*/

public int majorityNum (int[] nums, int k) {
	if (nums == null || nums.length == 0) {
		return 0;
	}

	Arrays.sort(nums);//O(nlogn)

	int count = 1;
	int obj = nums[0];
	int stop = nums.length / k;
	//O(n)
	for (int i = 1; i < nums.length; i++) {
		if (obj != nums[i]) {
			if (count > stop) {
				return obj;
			}
			obj = nums[i];
			count = 1;
		}else {
			count++;
		}
	}

	return obj;
}