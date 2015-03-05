import java.util.*;



//A random generator (like a speakerstanding in a group housie game calls out a number) generates out any numberfrom 1 to 1000. 
//There is a 10X10 matrix. A random generator assigns valuesto each block of this matrix(within 1 to 1000 obviously).
//Whenever, a row or a column or a diagonal is fully filled in this 10x10 fromthe numbers called out by the speaker, 
//its called a 'Mingo'. Write aprogram that will find first Mingo, then second Mingo, then thirds Mingo...andso forth.


//Assume: same number in matrix is accepted. 

public class Mingo {
	
	int[] rows;
	int[] cols;
	int[] diagonalUpperRight;
	int[] diagonalUpperLeft;
	int count = 1;
	int[][] dataBoard;
	int left;
	
	public void test(){
		sol(10);
	}
	
	public void init(int m){
		int n = m;
		left = m*m;
		dataBoard = new int[n][n];
		
		rows = new int[n];
		cols = new int[n];
		diagonalUpperRight = new int[2*n+1];
		diagonalUpperLeft = new int[2*n+1];
		
		Arrays.fill(rows, n);
		Arrays.fill(cols, n);
		
		for(int i = 0; i <= n; i++){
			diagonalUpperRight[i] = i+1;
			diagonalUpperLeft[i] = i+1;
			diagonalUpperRight[2*n-i] = i+1;
			diagonalUpperLeft[2*n-i] = i+1;
		}
	}
	
	public void sol(int n){
		this.init(n);
		while(left > 0){
			int randomIndex = (int) (Math.random()*99);
			int data = (int)(Math.random()*999) + 1;
			
			while(dataBoard[randomIndex/10][randomIndex%10] != 0){
				randomIndex = (int) (Math.random()*99);
			}
			
			dataBoard[randomIndex/10][randomIndex%10] = data;
			
			int x = randomIndex/10;
			int y = randomIndex%10;
			this.checkCol(x, y);
			this.checkRow(x, y);
			this.checkUpperLeft(x, y, n);
			this.checkUpperRight(x, y);
			left --;
		}
	}
	
	public void checkRow(int x, int y){
		rows[x]--;
		if(rows[x] == 0){
		System.out.println("The " + count + " Mingo");
		count ++;
		}
	}
	
	public void checkCol(int x, int y){
		cols[x]--;
		if(cols[x] == 0){
			System.out.println("The " + count + " Mingo");
			count ++;
			}
	}
	
	public void checkUpperRight(int x, int y){
		diagonalUpperRight[x+y]--;
		if(diagonalUpperRight[x+y] == 0){
			System.out.println("The " + count + " Mingo");
			count ++;
			}
	}
	
	public void checkUpperLeft(int x, int y, int n){
		int tempX = x;
		int tempY = y;
		
		while(tempX != 0 && tempY != 0){
			tempX --;
			tempY --;
		}
		
		int index = 0;
		
		if(tempX + tempY == 0) index = n - 1;
		if(tempX > tempY) index = n + tempX - 1;
		if(tempX < tempY) index = n - tempY - 1;
		
		diagonalUpperLeft[index] --;
		if(diagonalUpperLeft[index] == 0){
			System.out.println("The " + count + " Mingo");
			count ++;
			}
	}
}