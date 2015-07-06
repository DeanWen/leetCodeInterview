/*
* 把最大边长存在右下角
* 1 1  变成  1  1
* 1 1        1  2
* Function: 
dp[i][j] = Math.max(dp[i - 1][j - 1], max(dp[i - 1][j], dp[i][j - 1]));
*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        
        //initialization
        for (int i = 0; i < row; i++) {
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            max = Math.max(dp[i][0], max);
        }
        for (int j = 0; j < col; j++) {
            dp[0][j] = Character.getNumericValue(matrix[0][j]);
            max = Math.max(dp[0][j], max);
        }
        
        //dp calculation
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return max * max;
    }
}