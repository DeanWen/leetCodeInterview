import java.util.*;


//add two big integers

public class AddBigNumber {

	public String sol(String str1, String str2){
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 + len2 == 0) return "0";
		
		if(len1 <= len2) {
			return helper(str1,str2);
		}else{
			return helper(str2,str1);
		}
	}

	public String helper(String shorterNum, String longerNum){
		StringBuilder result = new StringBuilder(longerNum);
		StringBuilder shorter = new StringBuilder(shorterNum);
		
		shorter.reverse();
		result.reverse();
		
		int cap = 0;
		for(int i = 0; i < shorter.length(); i++){
			int shorterdigit = 0;
			shorterdigit = Character.getNumericValue(shorter.charAt(i));
			int addup = cap + shorterdigit + Character.getNumericValue(result.charAt(i));
			int remain = addup%10;
			cap = addup/10;
			result.setCharAt(i, (char)(remain+48));
		}
		if(cap != 0) result.append((char)(cap+48));
		result.reverse();
		return result.toString();
	}
}