public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(result, list, num, target, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int[] num, int target, int position) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        int prev = -1;
        for (int i = position; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (prev != -1 && prev == num[i]) {
                continue;
            }
            
            list.add(num[i]);
            helper(result, list, num, target - num[i], i + 1);
            list.remove(list.size() - 1);
            prev = num[i];
        }
    }
}