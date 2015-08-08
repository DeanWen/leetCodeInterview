public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums; i++) {
            twos |= ones & A[i];
            ones ^= A[i];// 异或3次 和 异或 1次的结果是一样的
           //对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}