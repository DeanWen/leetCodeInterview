import java.util.*;


//Print all valid phone numbers of length n subject to following constraints: 
//
//If a number contains a 4, it should start with 4 
//
//No two consecutive digits can be same 
//
//Three digits (e.g. 7,2,9) will be entirely disallowed, take as input


public class TelephoneNumber {

	List<Integer> digits = new ArrayList<Integer>();
	
	public void sol(int n, List<Integer> banned){
		for(int i = 0; i < 9; i ++){
			if(!banned.contains(i))
			digits.add(i);
		}
		helper(n,"", -1);
	}
	
	public void helper (int remain, String number, int last){
		if(remain == 0){
			System.out.println(number);
			return;
		}
		
		for(int i = 0; i < digits.size(); i++){
			int curr = digits.get(i);
			if(curr == last) continue;
			if(curr == 4){				
				if(number.length()!=0 && number.charAt(0)!='4') continue;
			}
			number += digits.get(i);
			helper(remain-1, number, curr);
			number = number.substring(0,number.length()-1);
		}
	}
}