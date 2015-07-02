public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        String[] symbols = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(digits, res, symbols, sb, 0);
        return res;
    }
    
    public void helper(String digits, List<String> res, String[] symbols, StringBuilder sb, int pos) {
        if(pos == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        int num = Character.getNumericValue(digits.charAt(pos));
        for (int i = 0; i < symbols[num].length(); i++) {
            sb.append(symbols[num].charAt(i));
            helper(digits, res, symbols, sb, pos + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}