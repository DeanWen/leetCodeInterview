public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        StringBuilder sb = new StringBuilder();
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                continue;
            }
            max = nums[i - 1];
            if (max != min) {
                sb.append(min).append("->").append(max);
            }else {
                sb.append(max);
            }
            res.add(sb.toString());
            min = nums[i];
            sb.setLength(0);
        }

		if (min != nums[nums.length - 1]) {
			sb.append(min).append("->").append(nums[nums.length - 1]);
		}else {
        	sb.append(nums[nums.length - 1]);
		}
		res.add(sb.toString());
        return res;
    }
}