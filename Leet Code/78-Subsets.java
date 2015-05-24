/*
* Subsets Thoughts:
* using recursion to enum every situation
* first sort the array,
* when finish scan, delete the last element
* move start point to the next 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //if S is empty set, return empty;
        if (S == null || S.length == 0) {
            return  result;
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(S);
        subsetHelper(result, S, temp, 0);
        
        return result;
    }
    
    public void subsetHelper(ArrayList<ArrayList<Integer>> result,
                             int[] S, 
                             ArrayList<Integer> temp,
                             int position) {   

        result.add(new ArrayList<Integer>(temp));
        
        for (int i = position; i < S.length; i++) {
            temp.add(S[i]);
            subsetHelper(result, S, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}