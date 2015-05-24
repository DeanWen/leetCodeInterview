/* Time Complexity : O(log n)
*
*Use Binary Search to narrow the range
*To find the last num less than the target
*The important is the corner case like
* [1] 2 
* [1] 0
* [1] 1
* [1,2] 2
* [1,2] 3
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        
        return start;
    }
}

public class Solution {
    public int searchInsert(int[] A, int target) {        
        int start = 0;
        int end = A.length -1;
        
        //find the last num less than the target
        //while loop won't execute if length < 3
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }else if (A[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        //above are Binary Search Template
        //after above start + 1 = end; 
        //check corner case
        if (target <= A[start]) {
            //if same or less should insert at beginning;
            return start;
        }else if (target == A[end]) {
            //if equals, should insert the same index;
            return end;
        }else if (target > A[end]) {
            //only if bigger, should insert after current index;
            return end + 1;
        }else {
            //the last position less than target is start
            return start + 1;
        }
    }
}