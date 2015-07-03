/*
*   Time Complexity : O(n)
*   Space Complexity : O(n)
*/
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        String left = "({[";
        
        for (int i = 0; i < s.length(); i++) {
            if (left.contains(String.valueOf(s.charAt(i)))) {
                stack.push(s.charAt(i));
            }else {
                if (!stack.isEmpty() && isValid(stack.peek(), s.charAt(i))) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isValid(char c1, char c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') 
            || (c1 == '[' && c2 == ']')) {
            return true;
        }
        return false;
    }
}