public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1; 
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    int insert = dp[i - 1][j] + 1;
                    int delete = dp[i][j - 1] + 1;
                    int update = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(Math.min(insert, delete), update);
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
}