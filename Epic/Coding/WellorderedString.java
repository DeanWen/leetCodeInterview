import java.util.*;


//You know a password is well-ordered string. Well-ordered stringmeans that the order of the characters is in an alphabetical increasing order.
//Like abEm is a well-ordered number. However, abmE is not a well-order number. 
//Givenan input # that tells you also how many digits are in the password, print allpossible passwords.

public class WellorderedString {

	public void sol(int num){
		if(num == 0 || num > 26) return;
		helper(num,new StringBuilder(),0);
	}

	public void helper(int n, StringBuilder sb, int pointer){
		if(n == 0){
			System.out.print("||" + new String(sb));
			return;
		}
		for(int i = pointer; i < 26; i++){
			char currLow = (char)('a' + i);
			char currCap = (char)('A' + i);
			sb.append(currLow);
			helper(n-1, sb, i+1);
			sb.deleteCharAt(sb.length()-1);
			sb.append(currCap);
			helper(n-1,sb,i+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}