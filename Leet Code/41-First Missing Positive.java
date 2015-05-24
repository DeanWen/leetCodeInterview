/*
** Time Complexity is O(n)
** Space Complexity is O(1)
**
    跟Counting sort一样，利用数组的index来作为数字本身的索引，
    把正数按照递增顺序依次放到数组中。即让A[0]=1, A[1]=2, A[2]=3, ... , 
    这样一来，最后如果哪个数组元素违反了A[i]=i+1即说明i+1就是我们要求的第一个缺失的正数。
**  http://blog.csdn.net/linhuanmars/article/details/20884585
**
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
}