import java.util.*;



// Phone has letters on the number keys. forexample, number 2 has ABC on it, number 3 has DEF, 4 number has GHI,... , andnumber 9 has WXYZ. 
//Write a program that will print out all of the possible combination of those letters depending on the input. 


public class KeypadPermutation {
	
	String[] board = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	
	public void sol(String digits){
		helper(0,digits,"");
	}
	
	public void helper(int index, String digits, String path){
			if(index == digits.length()){
				System.out.println(path);
				return;
			}
			String possible = board[Character.getNumericValue(digits.charAt(index))];
			int len = possible.length();
			for(int i = 0; i < len; i++){
				path += possible.charAt(i);
				helper(index+1, digits, path);
				path = path.substring(0, path.length()-1);
			}
	}
}