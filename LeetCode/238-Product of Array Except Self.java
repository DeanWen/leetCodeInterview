/*
* Main thought
* 2 PASS
* First Round
*   Store all product except self in left
* Second Round
*   Store all product except self in right
* First Round * Second Round will be the product except for entire array
* Brill!ant!!!!!
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] res = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        
        return res;
    }
}