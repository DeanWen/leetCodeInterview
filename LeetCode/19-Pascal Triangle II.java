public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int[] temp = new int[rowIndex + 1];
        for (int i = 0; i < temp.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == temp.length - 1) {
                    temp[j] = 1;
                }else {
                    temp[j] += temp[j - 1];
                }
            }
        }
        
        for (int num : temp) {
            result.add(num);
        }
        
        return result;
    }
}