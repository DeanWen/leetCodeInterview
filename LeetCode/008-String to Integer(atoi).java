public class Solution {
    private final int maxDiv10 = Integer.MAX_VALUE / 10;

    public int myAtoi(String str) {
    	int i = 0;
    	int len = str.length();

    	while(i < len && Character.isWhitespace(str.charAt(i))) {
    		i++;
    	}

    	int sign = 1;
    	if (i < len && str.charAt(i) == '+') {
    		i++;
    	}else if (i < len && str.charAt(i) == '-') {
    		i++;
    		sign = -1;
    	}

    	int num = 0;
    	while (i < len && Character.isDigit(str.charAt(i))) {
    		int digit = Character.getNumericValue(str.charAt(i));
    		if (num > maxDiv10 || (num == maxDiv10 && digit >= 8)) {
    			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    		}
    		num = num * 10 + digit;
    		i++;
    	}
    	return sign * num;
    }
}