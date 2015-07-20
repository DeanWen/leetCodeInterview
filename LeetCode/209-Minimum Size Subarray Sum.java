/*
* O(n) solution 
* Main thought:
*   use two pointer, and the sum
*   start [0, end] to find the sum >= s
* then
*   narrow the range to [start, end] by removing head number
* always update the res to keep the Math.min
*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
         if(nums == null || nums.length == 0) {
            return 0;
         }

        int start = 0, end = 0, sum = 0 , res = nums.length;
    
        while(end != nums.length) {
            if((sum + nums[end]) < s) {
                if (end == nums.length - 1) {
                    return 0;
                }
                sum += nums[end++];
                continue;
            }
    
            sum += nums[end++];
            while((sum - nums[start]) >= s){
                sum -= nums[start++];
                if(start == end - 1) {
                    return 1;
                }
            }
            res = Math.min(end - start, res);
        }
        
        return res;
    }
}