/**
*Thoughts mostly same to Search Rotated Array
*Key point: To find skip the duplicates numbers
*Diffecence: if A[start] >= A[mid] does NOT mean A
*
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