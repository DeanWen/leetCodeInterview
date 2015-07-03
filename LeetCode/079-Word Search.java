public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(char[][] board, int i, int j, String word, int start, boolean[][] visited) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(start)) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        boolean result = helper(board, i + 1, j, word, start + 1, visited) ||
                          helper(board, i - 1, j, word, start + 1, visited) ||
                          helper(board, i, j + 1, word, start + 1, visited) || 
                          helper(board, i, j - 1, word, start + 1, visited);
        visited[i][j] = false;
        return result;
    }
    
}