/*
分析：
首先咱们看看为什么这个解法正确。maxProfit有两个来源：一是历史最大利润（也就是原来的maxProfit值，不包含今日交易）。
一个是由包括今日交易构成的新的最大利润（即prices[i ] - minPrice）。
这确保了截至今天结束，所有可能产生最大利润的交易情况都被包括了。

之所以在计算maxProfit之后更新minPrice,是因为卖必须在买之后发生。
（所以即使当前的prices[i ]很小，也只能供 i+1 ~ prices.length-1 天的交易来使用了， 而不能被i之前的天使用）。

复杂度分析：
时间上是对数组的一次遍历。O（n）
空间上是两个变量： O（1）
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int maxProfit = 0;
        int min = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        
        return maxProfit;
    }
}