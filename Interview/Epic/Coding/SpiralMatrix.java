import java.util.*;


//Given aNXN matrix, starting from the upper right corner of the matrix start printing values in a counter-clockwise fashion. 
//E.g.: Consider N = 4 
//Matrix= {a, b, c, d,
//        e, f, g, h, 
//        i, j, k, l, 
//        m, n, o, p} 
//Your function should output: dcbaeimnoplhgfjk 



public class SpiralMatrix {
	
	public void test(){
		char[][] theboard = {{'a','b','c','d'}, {'e','f', 'g', 'h'}, {'i','j','k','l'}, {'m','n','o','p'}};
		char[][] theboard2 = {{'a','b'}, {'c','d'}};
		this.sol(theboard2);
	}
	
	public void sol(char[][] board){
		int n = board.length;
		if(n==0) return;
		if(n == 1){
			System.out.println(board[0][0]);
			return;
		}
		int upperLeftX = 0;
		int upperLeftY = 0;
		
		int upperRightX = n-1;
		int upperRightY = 0;
		
		int bottomLeftX = 0;
		int bottomLeftY = n-1;
		
		int bottomRightX = n-1;
		int bottomRightY = n-1;
		
		StringBuilder result = new StringBuilder();
		
		int pointerX = upperRightX;
		int pointerY = upperRightY;  //from upper right
		
		end: while(true){
			boolean changed = false;
			//<-
			for(int cols = upperRightX; cols > upperLeftX; cols--){
				result.append(board[upperRightY][cols]);
				changed = true;
			}
			upperRightX--;
			upperRightY++;
			
			//down
			for(int rows = upperLeftY; rows < bottomRightY; rows++){
				result.append(board[rows][upperLeftX]);
				changed = true;
			}
			upperLeftX ++;
			upperLeftY ++;
			
			//right
			for(int cols = bottomLeftX; cols < bottomRightX; cols++){
				result.append(board[bottomLeftY][cols]);
				changed = true;
			}
			bottomLeftX++;
			bottomLeftY--;
			
			//up
			for(int rows = bottomRightY; rows >= upperRightY; rows--){//这里UP是最后一个动作，所以要用等号
				result.append(board[rows][bottomRightX]);
				changed = true;
			}
			bottomRightX --;
			bottomRightY --;
			
			if(!changed) break; 
		}
		
		System.out.println(result.toString());
	}
	
	
	
}