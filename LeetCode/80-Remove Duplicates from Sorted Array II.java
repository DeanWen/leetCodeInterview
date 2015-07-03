public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        
        int newLen = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            }else {
                count = 0;
            }
            
            if (count < 2) {
                newLen++;
            }
            nums[newLen] = nums[i];
        }
        return newLen + 1;
    }
}