/*
*   Main Idea
*       Replace the target by the last element of array
*       Attention, need i-- to re-check the replacement
*   Time Complexity : O(n)
*   Space Complexity : O(1)
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int newLength = A.length;
        for (int i = 0; i < newLength; i++) {
            if (A[i] == elem) {
                A[i] = A[newLength - 1];
                newLength--;
                i--;
            }
        }
        
        return newLength;
    }
}