/*
* 排列组合模版
* Subsets 
**/
public class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		Arrays.sort(num);
		subsetsHelper(result, path, num, 0);

		return result;
	}

	public void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path,
			int[] num, int position){

		result.add(new ArrayList<Integer>(path));

		for (int i = position; i < num.length; i++){
			path.add(num[i]);
			subsetsHelper(result, path, num, i + 1);
			path.remove(path.size() - 1);
		}
	}
}

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if (num == null || num.length == 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, num);
        
        return result;
    }  
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }
            
            list.add(num[i]);
            helper(result, list, num);
            list.remove(list.size() - 1);
        }
    }
}
