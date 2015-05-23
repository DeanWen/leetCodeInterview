/*
Find the Top K frequency number in a array.
For example:
[1, 2, 3, 1, 2, 3, 4, 4, 5, 4, 4], k = 3
return: [4, 2, 1] or [4, 1, 3] or [4, 2, 3]
[1, 1, 1, 2, 2, 3, 4] , k = 2
return : [1, 2]

Time Complexity : O(n)
Space Complexity : O(1)
Worst Case is every char in base need loop m times:
Base: 	aaaaa
Target: ac
*/
public class Solution {
	public class Element {
		int value;
		int time;
		Element(int v, int t) {
			value = v;
			time = t;
		}
	}
	
	public List<Integer> findTopK (int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		PriorityQueue<>	pq

	}

}