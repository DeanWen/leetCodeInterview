/*
* using count to record the # of the same element
* using newIndex to control the arrary index.
* if count < 2 continue copying element to new order
* if count > 2 newIndex does not change, let next different element 
* to cover current. 
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        if (A.length < 3) {
            return A.length;
        }
        
        int newlength = 0;
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] == A[i]) {
                count++;
            }else {
                count = 0;
            }
            
            if (count < 2) {
                newlength++;
            }
            
            A[newlength] = A[i];
        }
        
        return newlength+1;
    }
}