public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n < 0) {
            return result;
        }
        ArrayList<Integer> cols = new ArrayList<Integer>();
        helper(result, cols, n);
        return result;
    }
    
    public void helper(ArrayList<String[]> result, ArrayList<Integer> cols, int n) {
        if (cols.size() == n) {
            result.add(drawChessboard(cols));
            return;            
        }
        
        for (int i = 0; i < n; i++) {
           if (!isValid(cols, i)) {
               continue;
           }
           
           cols.add(i);
           helper(result, cols, n);
           cols.remove(cols.size() - 1);
        }
    }
    
    public boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if(cols.get(i) + i == col + row) {
                return false;
            }
            if (cols.get(i) - i == col - row) {
                return false;
            }
        }
        return true;
    }
    
    public String[] drawChessboard(ArrayList<Integer> cols) {
        String[] chessboard = new String[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            chessboard[i] = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    chessboard[i] += "Q";
                } else {
                    chessboard[i] += ".";
                }
            }
        }
        
        return chessboard;
    }
}