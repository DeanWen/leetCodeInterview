public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        List<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[candidates.length];
        helper(res, list, candidates, visited, target, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, boolean[] visited, int target, int pos) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            if (visited[i]) {
                continue;//ensure one element only appear once
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;//hanlde duplicates
            }
            
            list.add(candidates[i]);
            visited[i] = true;
            helper(res, list, candidates, visited, target - candidates[i], i + 1);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
