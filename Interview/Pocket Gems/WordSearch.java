
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(helper(board, word, visited, 0, i, j)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean helper(char[][] board, String word, boolean[][] visited, int pos, int i, int j) {
		if (pos == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if (word.charAt(pos) != board[i][j]) {
			return false;
		}
		if (visited[i][j]) {
			return false;
		}
		
		visited[i][j] = true;
		boolean res = helper(board, word, visited, pos + 1, i + 1, j) ||
				helper(board, word, visited, pos + 1, i - 1, j) ||
				helper(board, word, visited, pos + 1, i, j + 1) ||
				helper(board, word, visited, pos + 1, i, j - 1);
		visited[i][j] = false;
		return res;
	}
}
