public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!strs[i].isEmpty()) {
                sb.append(strs[i]).append(" ");
            }
        }
        
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}