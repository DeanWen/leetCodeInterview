import java.util.*;


//N*N matrix is given with input red or black.You can move horizontally, vertically or diagonally. 
//If 3 consecutive samecolor found, that color will get 1 point. 
//So if 4 red are vertically then pointis 2. Find the winner.


//只要找第二个就行了。 x x x x  两分，因为只有中间两个，是头尾都有的。
//0-draw 1-red wins 2- black wins=

public class TicTacToe {
	
	public void test(){
		char[][] theboard = {{'R','B','R','B','B'},

				   			 {'R','B','B','B','B'},

				   			 {'R','B','R','B','B'},

				   			 {'B','R','B','R','B'}};
		int score = this.sol(theboard);
		if(score == 1){
			System.out.println("Red wins");
		}else if(score == 2){
			System.out.println("Black wins");
		}else{
			System.out.println("Draw");
		}
	}
	
	public int sol(char[][] board){
		if(board.length == 0) return 0;
		if(board.length < 3 && board[0].length < 3) return 0;
		
		int redScore = 0;
		int blackScore = 0;
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == 'R') redScore += checkScore(i,j,board);
				if(board[i][j] == 'B') blackScore += checkScore(i,j,board);
			}
		}
		
		System.out.println("Red:" + redScore);
		System.out.println("Black:" + blackScore);
		
		if(redScore > blackScore){
			return 1;
		}else if(redScore < blackScore){
			return 2;
		}else{
			return 0;
		}
	}
	
	public int checkScore(int row, int col, char[][] board){
		int result = 0;
		int flag = 0;
		
		if(row > 0 && row < board.length-1){
			flag++;
			if(board[row-1][col] == board[row][col]){ 
				if(board[row+1][col] == board[row][col]){
					result++;
				}
			}
		}
		
		
		if(col > 0 && col < board[0].length - 1){
			flag++;
			if(board[row][col-1] == board[row][col]){
				
				if(board[row][col+1] == board[row][col]){
					result++;
				}
			}
		}
		
		
		//should check diagonal
		if(flag == 2){
			if(board[row+1][col+1] == board[row][col]){				
				if(board[row-1][col-1] == board[row][col]) result++;
			}
			if(board[row-1][col+1] == board[row][col]){				
				if(board[row+1][col-1] == board[row][col]) result++;
			}
		}
		
		return result;
	}
	
}