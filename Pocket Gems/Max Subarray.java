/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int res = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max + A[i], A[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}