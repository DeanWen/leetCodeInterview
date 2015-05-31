/*
*   Time Complexity O (n * m) m is the length of common prefix
*   Space Complexity O (1)
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < res.length() && j < strs[i].length()) {
                if (res.charAt(j) == strs[i].charAt(j)) {
                    j++;
                }else {
                    break;
                }
            }
            res = res.substring(0, j);
        }
        return res;
    }
}