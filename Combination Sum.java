public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(result, list, candidates, target, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int position) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        int prev = -1;
        for (int i = position; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (prev != -1 && prev == candidates[i]) {
                continue;
            }
            
            list.add(candidates[i]);
            helper(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
            prev = candidates[i];
        }
    }
}