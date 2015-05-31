public class Solution {
	public boolean exist(char[][] board, String word) { 
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		int m = board.length;
		int n = board.length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, i, j, 0, word, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean dfs (char[][] board, int i, int j, 
			int index, String word, boolean[][] visited) {
		if (index == word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}

		if (board[i][j] != word.charAt(index) || visited[i][j]) {
			return false;
		}

		visited[i][j] = true;
		boolean res = dfs(board, i + 1, j, index + 1, word, visited) ||
					  dfs(board, i - 1, j, index + 1, word, visited) ||
					  dfs(board, i, j + 1, index + 1, word, visited) ||
					  dfs(board, i, j - 1, index + 1, word, visited);
		visited[i][j] = false;
		return res;
	}
}