package lifeGame;

public class Solution {
	
	public void nextStep (int[][] board) {
		
	}
	
	public boolean isAlive(int[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		int count = 0;
		// (i-1, j+1), (i-1,j), (i-1, j-1)
		// (i, j+1), (i, j-1)
		// (i+1, j+1), (i+1, j), (i+1, j-1)
		if (i - 1 >= 0 && j + 1 < n && board[i - 1][j] == 1) {
			count++;
		}
		if (i - 1 >= 0 && board[i - 1][j] == 1) {
			count++;
		}
		if (i - 1 >=0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
			count++;
		}
		if (j + 1 < n && board[i][j + 1] == 1) {
			count++;
		}
		if (j - 1 >= 0 && board[i][j - 1] == 1) {
			count++;
		}
		if (i + 1 < m && j + 1 < n && board[i + 1][j + 1] == 1) {
			count++;
		}
		if (i + 1 < m && board[i + 1][j] == 1) {
			count++;
		}
		if (i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
			count++;
		}
		return count == 2 || count == 3;
	}

}
