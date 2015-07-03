public class Solution {
    public boolean searchMatrix (int[][] matrix, int target) {
        if (matrix == null || target < matrix[0][0]) {
            return false;
        }
        if (target > matrix[matrix.length - 1][0]) {
            return rowSearchHelper(matrix[matrix.length - 1], target);
        }
    
        //overall O(nlogn);
        for (int i = 1 ; i <= matrix.length; i++) {
            if (target == matrix[i - 1][0]) {
                return true;
            }
            if (target > matrix[i - 1][0] && target < matrix[i][0]) {
                return rowSearchHelper(matrix[i - 1], target);//O(logn);
            }
        }
        
        return false;
    }
    
    //binary search O(logn)
    public boolean rowSearchHelper (int[] row, int target) {
        int start = 0;
        int end = row.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > row[mid]) {
                start = mid + 1;
            }else if (target < row[mid]) {
                end = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}