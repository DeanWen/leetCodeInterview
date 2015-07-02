public class Solution {
    public int totalNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>(); 
        if (n <= 0) {
            return 0;
        }
        int[] columnIndex = new int[n];
        dfs(n, 0, columnIndex, result);  
        return result.size(); 
    }
    
    public void dfs(int n, int row, int[] columnIndex, ArrayList<String[]> result)  {
        if (row == n) {
            String[] unit = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == columnIndex[i]) {
                        s.append("Q");
                    }else {
                        s.append(".");
                    }
                }
                unit[i] = s.toString();
            }
            result.add(unit);
        }else {
            for (int i = 0; i < n; i++) {
                columnIndex[row] = i; //columnIndex[row] => (row,column)
                if (isValid(row, columnIndex)) {
                    dfs(n, row + 1, columnIndex, result);
                }
            }
        }
    }
    
    public boolean isValid(int row, int[] columnIndex) {
        for (int i = 0; i < row; i++) {
            if (columnIndex[row] == columnIndex[i] || 
                Math.abs(columnIndex[row] - columnIndex[i]) == row - i) {
                    return false;
                }
        }
        return true;
    }
}