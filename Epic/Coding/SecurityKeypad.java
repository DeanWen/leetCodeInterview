import java.util.*;

//There is a security keypad at the entrance ofa building. It has 9 numbers 1 ¨C 9 in a 3¡Á3 matrix format.
//1 2 3
//4 5 6
//7 8 9 . from: 1point3acres.com/bbs
//The security has decided to allow one digit error for a person but that digitshould be horizontal or vertical. 
//Example: for 5 the user is allowed to enter2, 4, 6, 8 or for 4 the user is allowed to enter 1, 5, 7. 
//IF the security codeto enter is 1478 and if the user enters 1178 he should be allowed. Write afunction to take security code from the user and print out if he should beallowed or not.

public class SecurityKeypad {

	public List<String> pathresult = new ArrayList<String>();
	
	int[][] theboard = {{1,2,3},{4,5,6},{7,8,9}};
	
	public void test() {
		boolean allow = this.sol("1178","1478");
		System.out.println(allow);
	}
	
	public boolean sol(String inputted, String password) {
		int lenInput = inputted.length();
		int lenPass = password.length();
		
		if(lenInput != lenPass) return false;
		
		boolean errorUsed = false;
		
		for(int i = 0; i < lenPass; i++){
			int currInput = inputted.charAt(i);
			int currPass = password.charAt(i);
			
			if(currPass == currInput){
				continue;
			}else{
				if(errorUsed){
					return false;
				}else{
					errorUsed = true;
					int currPassDigit = Character.getNumericValue(currPass);
					int row = (currPassDigit-1)/3;
					int col = (currPassDigit-1)%3;
					int currInputDigit = currInput-48;
					if(checkAlternate(row,col,currInputDigit)){
						continue;
					}else{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean checkAlternate(int row, int col, int digit){
		if(col != 0){
			if(digit == theboard[row][col-1]) return true;
		}
		if(row != 0){
			if(digit == theboard[row-1][col]) return true;
		}
		if(col != 2){
			if(digit == theboard[row][col+1]) return true;
		}
		if(row != 2){
			if(digit == theboard[row+1][col]) return true;
		}
		return false;
	}
}