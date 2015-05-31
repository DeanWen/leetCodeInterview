/*
*   Container With Most Water 
*   Using two pointers
*   keep a globle max and update it
*   similar to best time buy and sell stock
*   
*   Time Complexity : O(n)
*   Space Complexity: O(1)
*/
public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        
        while (left < right) {
            //area = length * height
            //height is the min value between two sides
            int area = (right - left) * Math.min(height[left], height[right]);
            //keep max updated
            max = max > area ? max : area;
            //two pointer squeezing
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        
        return max;
    }
}