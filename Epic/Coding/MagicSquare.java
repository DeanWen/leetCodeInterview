import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//A magic square of order n is an arrangement of thenumbers from 1 to n^2 in an n by n matrix with each number occurring exactlyonce 
//so that each row, each column and each main diagonal has the same sum. Then should be an odd number. In the middle cell of the top row, 
//fill number 1.Then go to above row and right column, and fill following number 2. If it¡¯s outof boundary, go to the opposite row or column. 
//If the next cell is alreadyoccupied, go to the cell below this cell and fill following number. An exampleof 5*5 grid is like this for the first 9 numbers:
//0 0 1 8 0
//0 5 7 0 0
//4 6 0 0 0
//0 0 0 0 3
//0 0 0 2 9

public class MagicSquare {

	public void test() {
		int[][] result = sol(7);
		for(int i = 0; i < result.length; i++){
			for(int j = 0; j < result[0].length; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] sol(int n) {
		int[][] result = new int[n][n];
		int row = 0;
		int col = n / 2;
		int c = 1;
		while(c <= n*n) {
			if (result[row][col] == 0) {
				result[row][col] = c++;
				row--;
				col++;
				if (row == -1)
					row = n - 1;
				if (col >= n)
					col %= n;
			} else {
				row++;
				if(row>=n) row%=n;
			}
		}
		return result;
	}

}