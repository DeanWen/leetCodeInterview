public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] != 1) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] != 1) {
                dp[0][j] = 1;
            }else {
                break;
            }
        }
        
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[grid.length - 1][grid[0].length - 1];
    }
}