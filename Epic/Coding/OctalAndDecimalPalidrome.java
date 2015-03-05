import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//The decimal and octal values of some numbersare both palindromes sometimes. 
//Find such numbers within a given range.



public class OctalAndDecimalPalidrome {
	
	public void test(){
		sol(100, 888);
	}
	
	public void sol(int low, int high){
		for(int i = low; i <= high; i++){
			boolean success = this.checkNum(i);
			if(success){
				System.out.println(i + ":" + this.decimalToOctal(i));
			}
		}
	}
	
	public boolean checkNum(int num){
		String numStr = num + "";
		String oct = this.decimalToOctal(num);
		boolean octIsPalindrome = this.isPalindrome(oct);
		if(!octIsPalindrome) return false;
		return this.isPalindrome(numStr);
	}
	
	public String decimalToOctal(int num){
		String result = "";
		int temp = num;
		while(temp != 0){
			int remain = temp%8;
			temp /= 8;
			result = remain + result;
		}
		return result;
	}
	
	public boolean isPalindrome(String str){
		if(str.length() < 1) return true;
		int head = 0;
		int tail = str.length()-1;
		
		while(head < tail){
			if(str.charAt(head)!=str.charAt(tail)) return false;
			head ++;
			tail--;
		}
		return true;
	}
}