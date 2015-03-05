import java.util.*;

//Given an NxN matrix with unique integers :Find and print positions of all numbers such that it is the biggest in its row andalso the smallest in its column . e.g. : In 3 x 3 with elements
//1 2 3
//4 5 6
//7 8 9
//the number is 3 and position (1,3)

public class MatrixPosition {

	
	public void test() {
		int[][] theboard = {{1,2,3}, {4,5,6},{7,8,9}};
		this.sol(theboard);
	}

	public void sol(int[][] board) {
		
		int x = -1;
		int y = -1;
		
		rowloop: for(int row = 0; row < board.length; row++){
			int rowMax = Integer.MIN_VALUE;
			int tempX = -1;
			int tempY = -1;
			colloop: for(int col = 0; col < board[0].length; col++){
				if(board[row][col] > rowMax){
					rowMax = board[row][col];
					tempX = row;
					tempY = col;
				}
			}
			
			for(int row2 = 0; row < board.length; row++){
				if(row2 == row) continue;
				if(board[row2][tempY] < board[tempX][tempY]){
					tempX = -1;
					tempY = -1;
					break;
				}
			}
			
			if(tempX != -1 && tempY != -1){
				System.out.println("The number is " +  board[tempX][tempY] + " and the position is " + (tempX+1) + "," + (tempY+1));
				break rowloop;
			}
		}
	}
	
	
}