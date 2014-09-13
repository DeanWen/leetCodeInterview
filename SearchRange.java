public class Solution {
    public int[] searchInsert(int[] A, int target) {
        int[] bound = new int[2];
        int start, mid, end;
        
        if (A == null || A.length == 0) {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        //looking for left bound;
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (A[mid] == target) {
        		end = mid; 
        	}else if (A[mid] < target) {
        		start = mid;
        	}else {
        		end = mid;
        	}
        }

        if (A[start] == target) {
        	bound[0] = start;
        }else if (A[end] == target) {
        	bound[0] = end;
        }else {
        	bound[0] = bound[1] = -1;
        	return bound;
        }

        //looking for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (A[mid] == target) {
        		end = mid; 
        	}else if (A[mid] < target) {
        		start = mid;
        	}else {
        		end = mid;
        	}
        }

        if (A[end] == target) {
        	bound[1] = end;
        }else if (A[start] == target) {
        	bound[1] = start;
        }else {
        	bound[0] = bound[1] = -1;
        	return bound;
        }

        return bound;
    }
}