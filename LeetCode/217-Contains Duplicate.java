public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0 ; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }else {
                return true;
            }
        }
        
        return false;
    }
}