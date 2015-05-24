//Normal DP
/*
	State:  Global[i][j]第i天进行j次交易的最大利润
	Function: Global[i][j] = max(Global[i-1][j], Local[i][j])
	Initialization: Global[i][0] = 0 Global[0][j] = MIN_VALUE
*/
/*
	State:  Local[i][j]第i天进行j次交易的最大利润
	Function: Local[i][j] = max(Global[i-1][j-1]+ max(diff,0), Local[i-1][j]+diff)
	Initialization: Local[i][0] = 0 Local[0][j] = MIN_VALUE
*/


public int maxProfit (int[] prices, int k) {
	if (prices == null || prices.length == 0) {
		return 0;
	}

	int[][] global = new int[prices.length][k + 1];
	int[][] local = new int[prices.length][k + 1]; 

	for (int i = 1; i < prices.length; i++) {
		int diff = prices[i] - prices[i - 1];
		for (int j = 1; j < k; j++) {
			local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), 
				local[i-1][j] + diff);
			global[i][j] = Math.max(global[i-1][j], local[i][j]);
		}
	}
	
	return global[prices.length - 1][k];
}