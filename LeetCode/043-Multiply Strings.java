/*
* Main Idea
* 翻转string，低位到高位从左往右，因为数组是从左往右的，便于计算
* 把计算结果存到array，再处理进位等格式问题。
* StringBuilder insert(0, c) 从右往左插，然后删除leading 0
*/

public class Solution {
    public String multiply(String num1, String num2) {
        //reverse string
        //since array is left to right 
        //It's easier to compute
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        //store the calculation result to an array
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = (int) num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = (int) num2.charAt(j) - '0';
                res[i + j] += a * b;
            }
        }
        
        //format the result via stringbuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            int digit = res[i] % 10;
            int carry = res[i] / 10;
            //insert every lower digit to the right
            sb.insert(0, digit);
            if (i < res.length - 1) {
                res[i + 1] += carry;
            }
        }
        
        //delete all leading 0
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}