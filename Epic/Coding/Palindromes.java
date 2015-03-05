import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Print all palindromes of size greater than orequal to 3 of a given string. (How to do it with DP)?



public class Palindromes {
	
	public void test(){
		List<String> newList = sol("caba",3);
		System.out.println(newList);
	}
	
	public List<String> sol(String str, int leastLength){
		List<String> result = new ArrayList<String>();
		if(str.length() < leastLength) return result;
		int len = str.length();
		boolean[][] dp = new boolean[len][len];
		for(int i = len-1; i >= 0; i--){
			for(int j = len-1; j >= i; j--){
				if(i==j){
					dp[i][j] = true;
				}
				if(j-i >= 1 && str.charAt(i) == str.charAt(j)){
					if(j-i > 1){
						dp[i][j] = dp[i+1][j-1];
						if(j-i >= leastLength-1) result.add(str.substring(i,j+1));
					}else{						
						dp[i][j] = true;
					}
				}
			}
		}
		return result;
	}
	
	
}