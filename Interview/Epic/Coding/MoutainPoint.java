import java.util.*;

//Given a M * N matrix, if the element in thematrix is larger than other 8 elements who stay around it, then named thatelement be mountain point. Print all the mountain points.
public class MoutainPoint {
	
	List<Integer> result = new ArrayList<Integer>();
	
	public void test() {
		int[][] theboard = { {1,3,2,6,8}, {-9,7,1,-1,2},{1,5,0,1,9},{0,0,-1,1,1}};
		this.sol(theboard);
		System.out.println(result);
	}

	boolean[][] notMoutain;

	public void sol(int[][] board) {
		notMoutain = new boolean[board.length][board[0].length];
		
		//scan left to right and left to right
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length - 1; j++){
				if(board[i][j] >= board[i][j+1]) notMoutain[i][j+1] = true;
			}
			
			for(int j = board[0].length - 1; j > 0; j--){
				if(notMoutain[i][j-1]) continue;
				if(board[i][j] > board[i][j-1]) notMoutain[i][j-1] = true;
			}
		}
		
		//scan up to down, down to up
		for(int j = 0; j < board[0].length; j++){
			for(int i = 0; i < board.length - 1; i++){
				if(notMoutain[i+1][j]) continue;
				if(board[i][j] >= board[i+1][j]) notMoutain[i+1][j] = true;
			}
			
			for(int i = board[0].length - 1; i > 0; i--){
				if(notMoutain[i-1][j]) continue;
				if(board[i][j] > board[i-1][j]) notMoutain[i-1][j] = true;
			}
		}
		
		//put in the list
		for(int i = 0; i < notMoutain.length; i++){
			for(int j = 0; j < notMoutain[0].length; j++){
				if(!notMoutain[i][j]) result.add(board[i][j]);
			}
		}
	}
}