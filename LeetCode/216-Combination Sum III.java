public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new  ArrayList<List<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        dfs(res, tmp ,k , n, 1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int pos) {
        if (k == tmp.size()) {
            if (n == 0) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        
        for (int i = pos; i < 10; i++) {
            tmp.add(i);
            dfs(res, tmp, k, n - i, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}