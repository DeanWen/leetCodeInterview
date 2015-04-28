/*
思路：
使用动态规划。Kadane's algorithm.
使用局部最优和全局最优解法。局部最优是包含当前元素的最优解local（也就是说，当前元素组成了最优解的一部分）。全局最优是在所有历史最优解中选出的最优解global（可能包含当前元素组成的最优解local，也可能不包含）. E& U4 z5 P, |
1. 确定递推量 local和global7 c9 V) U' L, [0 ]) W9 w$ _
2. 推导递推式 local[i+1] = max(A, local+ A), global[i+1] = max(local[i+1], global)
3. 计算初始公式 local[0] = A[0] global[0] = A[0]
4. 考虑历史空间维度。由于我们仅仅需要上一步的local和global，并不需要全部的。所以我们可以从一维数组缩减到2个变量
*/

public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int local = A[0];
        int global = A[0];
        for (int i = 1; i < A.length; i++) {
            local = Math.max(A[i], local + A[i]);
            global = Math.max(local, global);
        }
        
        return global;
    }
}