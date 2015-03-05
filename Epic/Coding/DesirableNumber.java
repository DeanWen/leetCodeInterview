import java.util.*;


//A number is called 'desirable' if all thedigits are strictly ascending eg: 159 as 1<5<9. 
//You know that your rivalhas a strictly numeric password that is 'desirable'. 
//Your close ally has givenyou the number of digits (N) in your rival's password. WAP th\hjtat takes in'N' as input and prints out 
//all possible 'desirable' numbers that can be formedwith N digits.


public class DesirableNumber {

	int[] digits = {0,1,2,3,4,5,6,7,8,9};
	
	public void sol(int n){
		if (n>10) System.out.println("0123456789");;
		helper(n,0,"");
	}
	
	public void helper (int remain, int index, String password){
		if(remain == 0){
			System.out.println(password);
			return;
		}
		
		for(int i = index; i < digits.length; i++){
			password += digits[i];
			helper(remain-1, i+1, password);
			password = password.substring(0,password.length()-1);
		}
	}
}