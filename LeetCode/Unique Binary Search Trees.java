/*
首先，我们先从一些具体例子开始思考。
1) N = 0时，返回？
2) N = 1时，返回？
3) N = 2时，返回？
4) 有公式或者pattern可以用来生成结果吗？
5) N = i时的结果,能否用来产生N = k时的结果呢（i < k）
如果这些问题都有答案，那我们可以用递归（recursion）或者动态规划（DP）来解决

思路1： 递归
假设数组是有序的，如果无序则需要先排序再计算。我们把数组中的元素i 当做根，
那么可以得出：元素1 到 元素 i -1 等一共(i -1)个元素， 构成了元素i的左子树。
元素i+1到元素N等一共（N - i）个元素构成了元素i的右子树。
Index   0   1   ... i - 2   i - 1      i    i + 1   ... N-1
元素  1   2   ... i - 1      i    i+ 1    i + 2   ... N
对于元素i, 我们将可行左子树的数目*可行右子树的数目，得出的结果就是以i为根能够生成的unique bst数目。
由于i可以是1 ~ N的任意一个元素，所以我们要有一个for循环来遍历数组并累加求和。

*/

//Recursion
public class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i-1);
            int right = numTrees(n-i);
            sum += left * right;
        }
        
        return sum;
    }
}