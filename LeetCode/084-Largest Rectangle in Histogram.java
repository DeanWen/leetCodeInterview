//Time Complexity O(n)
//Space Complexity O(n)
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        while(i <= height.length){
            if(stack.isEmpty() || 
                (i != height.length && height[stack.peek()] <= height[i])){
                stack.push(i);
                i++;
            }else {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height[top] * width);
            }
        }
        return maxArea;
    }
}