/*
*	http://blog.csdn.net/m6830098/article/details/17291259
*	Time Complexity : O(n) actually O(3*n)
*	Space Complexity: O(1)
*/
public class Solution {
    public void nextPermutation(int[] nums) {
 		if (nums == null || nums.length == 0) {
 			return;
 		}

 		int i = nums.length - 2;
 		while (i >= 0 && nums[i] >= nums[i + 1]) {
 			i--;
 		}
 		
 		if (i >= 0) {
	 		int pos = i;
	 		int j = i + 1;
	 		while (j < nums.length && nums[j] > nums[pos]) {
	 			j++;
	 		}
	 		swap(nums, pos, j - 1);
 		}
 		
 		int left = i + 1;
 		int right = nums.length - 1;
 		while (left < right) {
 			swap(nums, left, right);
 			left++;
 			right--;
 		}
 	}

    private void swap (int[] nums, int a, int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}