public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        
        s = s.toLowerCase();
        //s = s.replaceAll("[^a-z^0-9]+","");
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (low < high && !helper(s.charAt(low))) {
                low++;
            }
            while (low < high && !helper(s.charAt(high))) {
                high--;
            }
            if (s.charAt(low) != s.charAt(high)) {
                break;
            }
            low++;
            high--;
        }
        
        if (low >= high) {
            return true;
        }else {
            return false;
        }
    }
    
    private boolean helper(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}