//Time Complexity : O(n)
//Space Complexity : O(1);
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!Character.isWhitespace(s.charAt(i))) {
                len++;
            }else if (len > 0) {// avoid last char is whitespace
                break;
            }
        }
        
        return len;
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n);
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }

        String[] strs = s.split(' ');
        return strs[strs.length - 1].length();
    }
}