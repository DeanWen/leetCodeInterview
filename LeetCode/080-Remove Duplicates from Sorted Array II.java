public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int num : nums) {
            //allow dups appear twice, so we have two case
            //1. count < 2
            //2. the third one should greater than two ahead of itself
            if (count < 2 || num > nums[count - 2]) {
                nums[count] = num;
                count++;
            }
        }
        return count;
    }
}
