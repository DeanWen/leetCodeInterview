public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs[0].length() == 0 || strs.length == 1) {
            return strs[0];
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int range = Math.min(prefix.length(), strs[i].length());
            int j = 0;
            while (j < range && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
        }
        
        return prefix;
    }
}