/**
* Binary Search Template
*/

public class Solution {
	public int binarySearch(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;

		// start + 1 < end to ensure mid exist
		while (start + 1 < end) {
			//
			int mid = start + (end - start) / 2;

			if (target == A[mid]) {
				return mid;
			}else if (target > A[mid]) {
				start = mid;
			}else {
				end = mid;
			}
		}

		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}

		return -1;
	}	
}