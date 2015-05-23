/*
*	Solution 1
*	We do not need to handle negative integers separately, 
*	because the modulus operator works for negative integers as well 
*	(e.g., –43 % 10 = –3)
*/
public class Solution {
	public int reverse(int x) {
		int ret = 0;
		while (x != 0) {
			// handle overflow/underflow before Mulitiplication
			if (Math.abs(ret) > Integer.MAX_VALUE / 10) {
				return 0;
			}
			ret = ret * 10 + x % 10;
			x /= 10;
		}
		return ret;
	}
}

/*
*	Solution 2
*	Dealing with Positvie & Negative sperately
*/
public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
        }
        
        x = Math.abs(x);
        int rst = 0;
        while(x != 0) {
            int digit = x % 10;
            x = x / 10;
            
            if (rst > (Integer.MAX_VALUE - digit)/10) {
            	return 0;
            }
            if (-rst < (Integer.MIN_VALUE + digit)/10) {
                return 0;
            }
                
            rst = rst * 10 + digit;
        }
        
        return negative ? -rst : rst;
    }
}