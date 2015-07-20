//Easy Bit Manipulation
public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        int x = 1;
        
        for (int i = 0; i < 32; i++) {
            x = n & 1;
            res = (res << 1) | x;
            n = n >> 1;
        }
        
        return res;
    }
}