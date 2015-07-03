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
*思路：判断是否为负数， 然后 绝对值求按位操作
*Key Point: 判断是否overflow int

*区别：
*rst > (Integer.MAX_VALUE - digit)/10
*rst * 10 + digit > Integer.MAX_VALUE
* 乘10之后，有可能左边已经越界了。
*/
public class Solution {
    public int reverse(int x) {
        //check the sign
        boolean negative = false;
        if (x < 0) {
            negative = true;
        }

        //keep absolute value to manipulate
        x = Math.abs(x);
        int rst = 0;
        while(x != 0){
            int digit = x % 10;
            x = x / 10;
            
            //check overflow max value of integer
            if (rst > (Integer.MAX_VALUE - digit)/10)
                return 0;
            if (-rst < (Integer.MIN_VALUE + digit)/10) 
                return 0;
                
            rst = rst * 10 + digit;//reverse
        }
        
        return negative ? -rst : rst;//assign sign
    }
}