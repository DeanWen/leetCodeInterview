public class Solution {
    public String convertToTitle(int n) {
        if (n < 1) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            char c = (char)('A' + (n - 1) % 26); //减1因为A to avoid 26 52 整除
            sb.insert(0, c);
            n = (n - 1) / 26;// 26进制
        }
        
        return sb.toString();
    }
}