public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        Arrays.sort(candidates);
        helper(result, item, candidates, target, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> item, 
                        int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0 && !result.contains(item)) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            item.add(candidates[i]);
            int newTarget = target - candidates[i];
            helper(result, item, candidates, newTarget, i);
            item.remove(item.size() - 1);
        }
    }
}