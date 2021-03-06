/**
*Use Binary Search to narrow the range
*Key point: To find the point that rotate the sequence
* one situation:
*	A[start]-A[mid] ordered
*	if target in A[start] - A[mid]
*		end = mid do binary search
*	else target in the rest part
*		start = mid
* The other situation:
*	A[start]-A[mid] not ordered:
*	if A[mid] - A[end] ordered
*		if target in A[mid] - A[end]
*			start = mid do binary search
*		else target in the rest part
*			end = mid search back
*/
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
				// A[start]-A[mid] ordered
				// if target in A[start] - A[mid]
				// 		end = mid do binary search
				// else target in the rest part
				// 		start = mid
        		if (A[start] <= target && target <= A[mid]) {
        			end = mid;
        		}else {
        			start = mid;
        		}
        	}else {
        		//*	A[start]-A[mid] not ordered:
				// if target in A[mid] - A[end]
				// 		start = mid do binary search
				// else target in the rest part
				// 		end = mid search back
        		if (A[mid] <= target && target <= A[end]) {
        			start = mid;
        		}else {
        			end = mid;
        		}
        	}
        }
        
        //start + 1 = end;
        // target is either start or end;
        if (A[start] == target) {
        	return start;
        }else if (A[end] == target) {
        	return end;
        }

        return -1;
    }
}

public class Solution {
    // O(1) space, O(logn) time
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == -1) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // right part is sorted
            if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1; 
                }
            } else {// left part is sorted
                if(target < nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        
        return -1;
    }
}