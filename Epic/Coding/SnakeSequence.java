import java.util.*;

//You are given a grid of numbers. A snakesequence is made up of adjacent numbers such that for each number, 
//the numberon the right or the number below it is +1 or -1 its value. For example, 
//1 3 2 6 8 . 
//-9 7 1 -1 2 
//1 5 0 1 9 
//In this grid, (3, 2, 1, 0, 1) is a snake sequence. Given a grid, find thelongest snake sequences and their lengths (so there can be multiple snakesequences with the maximum length).

public class SnakeSequence {

	public List<String> pathresult = new ArrayList<String>();
	
	public void test() {
		int[][] theboard = { {1,3,2,6,8}, {-9,7,1,-1,2},{1,5,0,1,9},{0,0,-1,1,1}};
		this.sol(theboard);
	}

	int[][] dp;
	int[][] directionDp; // 0-not coming from anywhere, 1-from left, 2-from up,
							// 3-from both

	public void sol(int[][] board) {
		if (board.length == 0)
			return;

		dp = new int[board.length][board[0].length];
		directionDp = new int[board.length][board[0].length];

		// fill up dp with 1
		for (int[] ele : dp) {
			Arrays.fill(ele, 1);
		}

		int maxlength = Integer.MIN_VALUE;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i + j == 0)
					continue;
				if (j != 0) {
					if (Math.abs(board[i][j - 1] - board[i][j]) == 1) {
						dp[i][j] = dp[i][j - 1] + 1;
						maxlength = Math.max(maxlength, dp[i][j]);
						directionDp[i][j] = 1;
					}
				}
				if (i != 0) {
					if (Math.abs(board[i - 1][j] - board[i][j]) == 1) {
						if (dp[i - 1][j] + 1 > dp[i][j]) {
							dp[i][j] = dp[i - 1][j] + 1;
							maxlength = Math.max(maxlength, dp[i][j]);
							directionDp[i][j] = 2;
							continue;
						}
						if (dp[i - 1][j] + 1 == dp[i][j]) {
							directionDp[i][j] = 3;
						}
					}
				}
			}
		}

		System.out.println("longest length is:" + maxlength);
		this.getPath(maxlength, board);
		
		for(String path: pathresult){
			System.out.println(path);
		}
	}

	public List<String> getPath(int longest, int[][] board) {
		List<String> result = new ArrayList<String>();
		String toResult = "";
		if (longest == 1) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					toResult += board[i][j];
				}
			}
			result.add(toResult);
			return result;
		}
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if(dp[i][j] == longest){
					helper(i,j,"",board);
				}
			}
		}
		return result;
	}
	
	public void helper(int pointerRow, int pointerCol, String path, int[][] board){
		int curr = board[pointerRow][pointerCol];
		path = curr + " " + path;
		if(directionDp[pointerRow][pointerCol] == 0){
			pathresult.add(path);
		}
		if(directionDp[pointerRow][pointerCol] == 1 || directionDp[pointerRow][pointerCol] == 3){
			helper(pointerRow,pointerCol-1,path,board);
		}
		if(directionDp[pointerRow][pointerCol] == 2 || directionDp[pointerRow][pointerCol] == 3){
			helper(pointerRow-1,pointerCol,path,board);
		}
	}
}