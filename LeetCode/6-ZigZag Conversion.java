/*
* ZigZag 
* 找规律题
* http://www.cnblogs.com/springfor/p/3889414.html
*   Time Complexity : O(n)
*   Space Complexity : O(n)
*/
public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int zigzag = 2 * nRows - 2;

        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += zigzag) {
                sb.append(s.charAt(j));
                if (i != 0 && i != nRows - 1) {
                    int temp = j + zigzag - 2 * i;
                    if (temp < s.length()) {
                        sb.append(s.charAt(temp));
                    }
                }
            }
        }

        return sb.toString();
    }
}