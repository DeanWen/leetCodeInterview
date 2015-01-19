public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n < k) {
            return result;
        }
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }
        List<Integer> list = new ArrayList<Integer>();
        helper(result, list, num, 0, k);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int[] num, int position, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = position; i < num.length; i++) {
            list.add(num[i]);
            helper(result, list, num, i + 1, k);
            list.remove(list.size() - 1);
        }
    }
}