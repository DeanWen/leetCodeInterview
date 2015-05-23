/*
*	Solution 1
*	Reverse the integer to compare with the original
*/
public class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	}

    	if (reverse(x) != x) {
    		return false;
    	}

    	return true;
    }

    private int reverse(int x) {
    	int res = 0;
    	while (x != 0) {
    		res = res * 10 + x % 10;
    		x /= 10;
    	}
    	return res;
    }
}

/*
*	Solution 2
*	Two pointers squeezing to the middle
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
       	    return false;
        }
        int div = 1;
        while ((x / div) >= 10) {
            div *= 10;
        }
       
        while (x != 0) {
            int left = x / div;
            int right = x % 10;
           
            if (left != right) {
               return false;
            }
           
           /*
           * Key Point:
           * remove first and last digit
           * divisor decrease 100 times every time
           */
           x = (x % div) / 10;
           div /= 100;
        }
       
       return true;
    }
}