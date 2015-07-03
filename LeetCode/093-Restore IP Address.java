public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        dfs(s, "", result, 0);
        return result;
    }
    
    private void dfs(String s, String item, List<String> result, int start) {
        if (start == 3 && isValid(s)) {
            result.add(item + s);
            return;
        }
        
        for (int i = start; i < 3 && i < s.length() - 1; i++) {
            String temp = s.substring(0, i + 1);
            if (isValid(temp)) {
                dfs(s.substring(i + 1, s.length()), item + temp + '.', result, i + 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        if (num > 0 && num <= 255) {
            return true;
        }else {
            return false;
        }
    }
}