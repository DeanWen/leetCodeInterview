public class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> path = new ArrayList<Integer>();
		helper(result, path, n, 1, k);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> path,
			int n, int position, int k){
		if (path.size() == k) {
			//Since Path is passed by value, 
			//it would be changed in further Recursion
			//so make a new copy here
			result.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = position; i <= n; i++) {
			path.add(i);
			helper(result, path, n, i + 1, k);
			path.remove(path.size() - 1);
		}
	}
}