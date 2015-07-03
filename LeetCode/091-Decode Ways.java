public class Solution {
    public int numDecodings(String s) { 
    	if(s == null || s.length() == 0 || s.equals("0")) {
    		return 0;
    	} 

    	int[] dp = new int[s.length() + 1];
    	dp[0] = 1;
    	dp[1] = s.charAt(0) != '0' ? 1 : 0;

    	for (int i = 2; i <= s.length(); i++) {
    		if (isValid(s.substring(i - 1, i))) {
    			dp[i] = dp[i - 1];
    		}
    		if (isValid(s.substring(i - 2, i))) {
    			dp[i] += dp[i - 2];
    		}
    	}

    	return dp[s.length()];
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        
    	int code = Integer.parseInt(s);
    	if (code >= 1 && code <= 26) {
    		return true;
    	}
    	
    	return false;
    }
}