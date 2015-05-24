public class Solution {
    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }
        
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 26; // 26进制的，每进一位要乘26
            num += s.charAt(i) - 'A' + 1; //加上当前位的数
        }
        
        return num;
    }
}