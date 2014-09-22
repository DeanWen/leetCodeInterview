public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return -1;
        }
        
        int height = triangle.size();
        int[] result = new int[triangle.get(height-1).size()];
        
        if (height == 1) {
            return triangle.get(0).get(0);
        }
        
        for (int i = 0; i < result.length; i++){
        	result[i] = triangle.get(height-1).get(i);
        }
        
        for (int i = height - 1; i > 0; i--) {
            for (int j = 0; j < triangle.get(i-1).size() ; j++) {
            		int min = findMinimum(result[j], result[j+1]);
                    int temp = triangle.get(i-1).get(j) + min;
                    result[j] = temp;
            }
        }
        
        return result[0];
    }
    
    public int findMinimum(Integer A1, Integer A2) {
        if (A1 < A2) {
            return A1;
        }else {
            return A2;
        }
    }
}