public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
        	return -1;
        }

        int start = 0;
        int end = A.length - 1; 

        while (start + 1 < end) {
        	int mid = start + (end - start) / 2 ;
        	if (A[mid] == target) {
        		return mid;
        	}else if (A[start] < A[mid]) {
        		//situation 1
        		if (A[start] <= target && target <= A[mid]) {
        			end = mid;
        		}else {
        			start = mid;
        		}
        	}else {
        		//situation 2
        		if (A[mid] <= target && target <= A[end]) {
        			start = mid;
        		}else {
        			end = mid;
        		}
        	}
        }

        if (A[start] == target) {
        	return start;
        }else if (A[end] == target) {
        	return end;
        }

        return -1;
    }
}