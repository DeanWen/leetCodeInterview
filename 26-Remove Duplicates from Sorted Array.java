/*
*   Main Idea
*       Replace the duplicates by the different, move all duplicates to
*       end of array
*       keep the duplicate count
*       
*   Time Complexity : O(n)
*   Space Complexity : O(1)
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            }else {
                nums[i - count] = nums[i];
            }
        }
        
        return nums.length - count;
    }
}