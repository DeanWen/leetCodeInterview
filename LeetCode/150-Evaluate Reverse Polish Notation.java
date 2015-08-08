public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int num1, num2;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                     num2 = stack.pop();
                     num1 = stack.pop();
                     stack.push(num1 + num2);
                     break;
                case "*":
                     num2 = stack.pop();
                     num1 = stack.pop();
                     stack.push(num1 * num2);
                     break;
                case "-":
                     num2 = stack.pop();
                     num1 = stack.pop();
                     stack.push(num1 - num2);
                     break;
                case "/":
                     num2 = stack.pop();
                     num1 = stack.pop();
                     stack.push(num1 / num2);
                     break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        
        return stack.pop();
    }
}