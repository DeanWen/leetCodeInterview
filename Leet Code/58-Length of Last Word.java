public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        String[] str = s.split("\\s+");
        return str[str.length - 1].length();
    }
}