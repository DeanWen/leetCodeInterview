//http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (Integer it : nums) {
            set.add(it);
        }
        
        int max = 0;
        for (Integer it: nums) {
            int left = it - 1;
            int right = it + 1;
            int count = 1;
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}