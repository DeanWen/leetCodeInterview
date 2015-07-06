/*
* The main idea is to determin whether select the first element
* ..0 1 2 3 4 0 ...
* if select first: 
* 	dp[0] = 0;
*	dp[1] = nums[0];
*	dp[i] = max(nums[i - 1] + dp[i - 2], dp[i - 1])
* if not:
* 	dp[0] = 0;
*	dp[1] = nums[1]; 
*	dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
*/
public class Solution {
    public int rob(int[] nums) {
 		if (nums == null || nums.length == 0) {
 			return 0;
 		}

 		if (nums.length < 3) {
 			return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
 		}

 		int[] dp1 = new int[nums.length];
 		int[] dp2 = new int[nums.length];

 		dp1[0] = 0;
 		dp1[1] = nums[0];
 		for (int i = 2; i < nums.length; i++) {
 			dp1[i] = Math.max(nums[i - 1] + dp1[i - 2], dp1[i - 1]);
 		}

 		dp2[0] = 0;
 		dp2[1] = nums[1];
 		for (int i = 2; i < nums.length; i++) {
 			dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
 		}

 		return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
    }
}