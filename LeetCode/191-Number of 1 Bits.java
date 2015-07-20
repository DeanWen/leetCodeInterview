//since its unsigned, 32 bits
// continue >> and & with 1
// count the 1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            count += (n >> i) & 1;
        }
        return count;
    }
}