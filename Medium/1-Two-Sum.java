/*
* Two Sum 
*
* Method 1 HashMap
* 	Time Complexity : O(n)
*	Space Complexity : O(n)
*	Two Cases:
*		1.With Duplication
*		2.Without Duplication
*/


/*
* With Duplication
* Thought Using HashMap<Integer, ArrayList<Integer>> to store all indexes
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (!map.containsKey(nums[i])) {
                list.add(i + 1);
            }else {
                list = map.get(nums[i]);
                list.add(i + 1);
            }
            map.put(nums[i], list);
        }
        
        int[] positions = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
            	/*
            	*	Since the Question assume there is only one solution
            	*	mean only one pair.if duplicate, there can only be 2 index
            	*	for the same key
				*/
                if (nums[i] == target - nums[i] && map.get(nums[i]).size() > 1) {
                     positions[0] = map.get(nums[i]).get(0);
                     positions[1] = map.get(nums[i]).get(1);
                     break;
                }
                
                int index1 = map.get(nums[i]).get(0);
                int index2 = map.get(target - nums[i]).get(0);
                if (index1 == index2) {
                    continue;
                }
                
                positions[0] = Math.min(index1, index2);
                positions[1] = Math.max(index1, index2);
            }
        }
        
        return positions;
    }
}

/*
* Without Duplication
* Thought Using HashMap<Integer, Integer> to store key - index
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
        	//No duplication, all key-value should be unique
            map.put(numbers[i], i+1);
        }
        
        int[] positions = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int index1 = i + 1;
                int index2 = map.get(target - numbers[i]);
                
                if (index1 == index2) {
                    continue;
                }
                
                positions[0] = Math.min(index1, index2);
                positions[1] = Math.max(index1, index2);
                return positions;
            }
        }
        return positions;
    }
}

/*
* Method 2 - Two Pointers
*	Time Complexity O(nlogn)
*	Space Complexity O(n)
*	This is capable for hanlding with/without duplications
*/

public class Solution {
    public int[] twoSum(int[] num, int target) {
        if (num == null || num.length == 0) {
            return null;
        } 
        /*
        *	Since sorting will break original array
        *	make a copy here
        *	using two pointer squeezing
        *	left
        *	right
        *	find two elements
        */
        int[] numbers = num.clone();//Space extra O(n)
        Arrays.sort(numbers);//O(nlogn)
        
        int left = 0;
        int right = numbers.length - 1;
        int[] elements = new int[2];
        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                elements[0] = numbers[left];
                elements[1] = numbers[right];
                break;
            }else if (numbers[left] + numbers[right] > target) {
                right--;
            }else {
                left++;
            }
        }
        
        /*
        * Find two elements in original array
        */
        int[] positions = {-1, -1};
        int low = 0;
        int high = num.length - 1;
        while (positions[0] == -1 || positions[1] == -1) {
            if (num[low] == elements[0]) {
                positions[0] = low + 1;
            }
            if (num[high] == elements[1]) {
                positions[1] = high + 1;
            }
            low++;
            high--;
        }
        
        /*
        * make sure the order follow 
        * [small index, large index];
        */
        int temp = positions[0];
        positions[0] = Math.min(temp, positions[1]);
        positions[1] = Math.max(temp, positions[1]);
        return positions;
    }
}
