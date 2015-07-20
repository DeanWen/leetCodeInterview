/*
* Element can only be 2 if each more than 1/3 of size
* find the candidate object 1 & 2 using Moors Voting Algorithm
* check if obj 1 & 2 occurs more than 1/3, if so add to the result 
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int obj1 = 0, obj2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (obj1 == nums[i]) {
                count1++;
            }else if (obj2 == nums[i]) {
                count2++;
            }else if (count1 == 0) {
                count1 = 1;
                obj1 = nums[i];
            }else if (count2 == 0) {
                count2 = 1;
                obj2 = nums[i];
            }else {
                count1--;
                count2--;
            }
        }
        
        count1 = count2 = 0;
        for (Integer it : nums) {
            if (it == obj1) {
                count1++;
            }else if (it == obj2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(obj1);
        }
        if (count2 > nums.length / 3) {
            res.add(obj2);
        }
        return res;
    }
}