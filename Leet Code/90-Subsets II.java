public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(result, list, num, 0);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int position) {
        if (!result.contains(list)) {
            result.add(new ArrayList<Integer>(list));
        }
        
        for (int i = position; i < num.length; i++) {
            list.add(num[i]);
            helper(result, list, num, i+1);
            list.remove(list.size() - 1);
        }
    }
}