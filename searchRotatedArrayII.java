/**
*Thoughts mostly same to Search Rotated Array
*Key point: To find skip the duplicates numbers
*Diffecence: if A[start] >= A[mid] does NOT mean A[mid] to A[start] in order
*Method: split every single situation
*   A[start] == A[mid] start ++; skip the duplicates
*   A[start] > A[mid] 
*       search target if among A[mid]-A[end] (suppose mid - end ordered)
*   if not
*       end = mid search back
*   A[start] < mid
*       search target if among A[start]-A[mid] (suppose start - mid ordered)
*   if not
*       start = mid search back
*/

public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int start = 0;
        int end = A.length - 1; 

        while (start + 1 < end) {
            int mid = start + (end - start) / 2 ;
            if (A[mid] == target) {
                return true;
            }else if (A[start] == A[mid]) {
                //key point: skip the duplicates
                start++;
            }else if (A[start] > A[mid]){
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                }else {
                    end = mid;
                }
            }
            else if (A[start] < A[mid]){
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                }else {
                    start = mid;
                }
            }
        }

        if (A[start] == target) {
            return true;
        }else if (A[end] == target) {
            return true;
        }

        return false;
    }
}