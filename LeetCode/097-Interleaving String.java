//http://blog.csdn.net/u011095253/article/details/9248073
//Time Complexity : O(n ^2)
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        
        //check if s3 come from s1
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i-1][0]) {
                dp[i][0] = true;
            }
        }
        //check if s3 come from s2
        for (int i = 1; i <= s2.length(); i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }
        //transit function
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) ||
                    (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])){
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}