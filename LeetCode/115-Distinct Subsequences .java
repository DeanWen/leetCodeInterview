/*
Let W(i, j) stand for the number of subsequences of S(0, i) 
equals to T(0, j). If S.charAt(i) == T.charAt(j), 
W(i, j) = W(i-1, j-1) + W(i-1,j);
Otherwise, W(i, j) = W(i-1,j).
*/
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for (int i = 0; i < s.length(); i++) {
		    dp[i][0] = 1;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[s.length()][t.length()];
    }
}