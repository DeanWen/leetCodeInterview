/*
* Time Complexity : O(n^2)
* Space Complexity : O(n)
*/
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int val = 0;
        if (num == null || num.length < 2) {
            return 0;
        }
        
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            
            while(left < right) {
                int sum = num[left] + num[right] + num[i];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    val = sum;
                }
                if (sum == target) {
                    return val;
                }else if (sum < target) {
                    left++;
                }else {
                    right--;
                }
                
            }
        }
        
        return val;
    }
}