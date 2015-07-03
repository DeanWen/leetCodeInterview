public class Solution {
    public static String simplifyPath(String path) {  
        if(path.length() == 0){  
            return path;  
        }  
        
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (String s : strs) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else {
                stack.push(s);
            }
        }
        
        String res = "";
        if (stack.isEmpty()) {
            stack.push(res);
        }
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        
        return res;
    }
}