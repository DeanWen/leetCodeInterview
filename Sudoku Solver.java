public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        helper(board, 0 ,0);
    }
    
    private boolean helper(char[][] board, int row, int col) {
        if (col == 9) {
            return helper(board, row + 1, 0);
        }
        if (row == 9) {
            return true;
        }
        
        if (board[row][col] == '.') {
            for (char num = '1'; num <= '9'; num++) {
                if (isValid(board, row, col, num)) {
                    board[row][col] = num;
                    if(helper(board, row, col + 1)) {
                        return true;
                    }else {
                        board[row][col] = '.';
                    }
                }
            }
        }else {
            return helper(board, row, col + 1);
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        //check row;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        //check columns;
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        //check subbox
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}