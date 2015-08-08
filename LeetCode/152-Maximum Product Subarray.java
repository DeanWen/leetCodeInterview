public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = A[0];
        int min = A[0];
        int result = A[0];
        
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(A[i] * max, A[i] * min), A[i]);
            min = Math.min(Math.min(A[i] * temp, A[i] * min), A[i]);
            if (max > result) {
                result = max;
            }
        }
        
        return result;
    }
}