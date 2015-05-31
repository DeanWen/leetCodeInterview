/*
*   Time Complexity : O(n!)
*   Space Complexity : O(n)
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        
        String[] symbols = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(digits, list, sb, symbols, 0); 
        return list;
    }
    
    private void helper(String digits, List<String> list, StringBuilder sb, String[] symbols, int index) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        
        int num = digits.charAt(index) - '0';
        for (int i = 0; i < symbols[num].length(); i++) {
            sb.append(symbols[num].charAt(i));
            helper(digits, list, sb, symbols, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}