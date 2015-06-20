public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> list = new ArrayList<String>();
        helper(result, list, s, 0);
        return result;
    }
    
    private void helper(List<List<String>> result, List<String> list, String s, int position) {
        if (position == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = position + 1; i <= s.length(); i++) {
            String prefix = s.substring(position, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            
            list.add(prefix);
            helper(result,list,s, i);
            list.remove(list.size() -1);
        }
    }
    
    private boolean isPalindrome (String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}