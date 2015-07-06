/*
* 8 : 1000
* 7 : 0111
* n & (n - 1) = 0000 
*/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
        	return false;
        }
        int res = n & (n - 1);
        return res == 0;
    }
}