/*
思路 ：brutal force 的思路是在上升区间最开始买入，
在结束时卖出，可以滑动窗口做，实现起来比较麻烦。简化之。由于可以在卖了手上股票之后马上购买，
所以只要股票存在涨幅，就进行买卖操作，即可获得最大利益。
举例： 1，2，3，4。1买，2卖，2再买，3卖，3再买，4卖，这样获得的总收益与1买，4卖的收益是一样的。
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        
        return profit;
    }
}