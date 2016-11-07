//in place, clock-wise line by line
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int y = 0; y < n / 2; y++){
            for(int x = y; x < n - 1 - y; x++){
                int temp = matrix[y][x];
                temp = move(matrix, temp, (n - 1) - y, x);
                temp = move(matrix, temp, (n - 1) - x, (n - 1) - y);
                temp = move(matrix, temp, y, (n - 1) - x);
                temp = move(matrix, temp, x, y);
            }
        }
    }
    
    public int move(int[][]matrix, int val, int x, int y){
        int store = matrix[y][x];
        matrix[y][x] = val;
        return store;
    }
}

//straghtforwarded the pattern is [x][y] -> [y][n - 1 - x]
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] target = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, target[i], 0, n);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = target[i][j];
            }
        }
    }
}
