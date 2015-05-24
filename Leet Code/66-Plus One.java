/*
* 末尾加一 ＝》 刚开始carry ＝ 1； 然后按十进制加法
* 极端情况，所有都是9， 最后要新开一个数组，首位为1，其余默认为0；
* 时间 O（k） O（1）
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            if (sum >= 10) {
                digits[i] = sum - 10;
                carry = 1;
            }else {
                digits[i] = sum;
                carry = 0;
                break;
            }
        }
        
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        
        return digits;
    }
}