/**
*Use Binary Search to narrow the range
*Step 1 : To find the left bound of target
*	key point is if A[mid] == target
*	let end = mid;
*	keep search left
*Step 2 : To find the right bound of target
*	key point is if A[mid] == target
*	let start = mid;
*	keep search right
*
*
*/
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] bound = new int[2];
        int start, mid, end;
        
        //check empty case;
        if (A == null || A.length == 0) {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        //looking for left bound;
		//key point is if A[mid] == target
		//let end = mid;
		//keep search left;
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
        //above are Binary Search Template
        //after above start + 1 = end; 
        //there are only 2 possible situation
        //start = target || end = target
        //target doesn't exist
        if (A[start] == target) {
        	bound[0] = start;
        }else if (A[end] == target) {
        	bound[0] = end;
        }else {
        	bound[0] = bound[1] = -1;
        	return bound;
        }

        //looking for right bound
		//key point is if A[mid] == target
		//let start = mid;
		//keep search right
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (A[mid] == target) {
        		start = mid; 
        	}else if (A[mid] < target) {
        		start = mid;
        	}else {
        		end = mid;
        	}
        }

        //above are Binary Search Template
        //after above start + 1 = end; 
        //there are only 2 possible situation
        //start = target || end = target
        //target doesn't exist
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