public int maxProfit (int[] prices) {
	if (prices == null || prices.length == 0) {
		return 0;
	}

	int[] left = new int[prices.length];
	int[] right = new int[prices.length];

	left[0] = 0;
	min = prices[0];
	for (int i = 1; i < prices.length; i++) {
		min = Math.min(min, prices[i]);
		left[i] = Math.max(left[i - 1], prices[i] - min);
	}

	right[prices.length - 1] = 0;
	max = prices[prices.length - 1];
	for (int i = prices.length - 2; i >= 0; i--) {
		max = Math.max(prices[i + 1], max);
		right[i] = Math.max(max - prices[i + 1], right[i + 1]);
	}

	int profit = 0;
	for (int i = 0; i < prices.length; i++) {
		profit = Math.max(left[i] + right[i], profit);
	}

	return profit;
}