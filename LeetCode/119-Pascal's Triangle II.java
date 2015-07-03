public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        
        int[] array = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i || j == 0) {
                    array[j] = 1;
                }else {
                    array[j] = array[j - 1] + array[j];
                }
            }
        }
        
        for (Integer it : array) {
            res.add(it);
        }
        return res;
    }
}