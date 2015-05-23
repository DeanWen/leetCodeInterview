public class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        
        String s = "1";
        for (int i = 1; i < n; i++) {
            int time = 1;
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    time++;
                }else {
                    sb.append(time).append(s.charAt(j-1));
                    time = 1;
                }
            }
            
            sb.append(time).append(s.charAt(s.length() - 1));
            s = sb.toString();
        }
        
        return s;
    }
}