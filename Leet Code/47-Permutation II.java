public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if (num == null || num.length == 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        helper(result, list, num, visited);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, boolean[] visited) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
             // 只能连续地选，这样就可以避免生成重复的solution.
             // 例子：1 2 3 4 4 4 5 6 7 8
             // 444这个的选法只能:4, 44, 444连续这三种选法
            if (visited[i] || (i > 0 && num[i] == num[i - 1] && visited[i - 1])) {
                continue;
            }
            
            visited[i] = true;
            list.add(num[i]);
            helper(result,list,num,visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}