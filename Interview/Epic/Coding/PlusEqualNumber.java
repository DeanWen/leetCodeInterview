import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Given a number find whether the digits in thenumber can be used to form an equation with + and ¡®=¡¯. 
//That is if the number is123, we can have a equation of 1+2=3. 
//But even the number 17512 also forms theequation 12+5=17.



public class PlusEqualNumber {
	
	public void test(){
		this.sol("17512");
		this.sol("123");
	}
	
	public void sol(String num){
		if(num.length() < 3) return;
		helper(2,"0",num,"","");
	}
	
	public void helper(int splitRemain, String sum, String rest, String first, String second){
		if(splitRemain == 2){
			for(int i = 0; i < rest.length()-2; i++){
				String firstpart = rest.substring(0, i+1);
				helper(splitRemain-1, firstpart, rest.substring(i+1, rest.length()), firstpart,"");
			}
		}
		if(splitRemain == 1){
			for(int i = 0; i < rest.length() - 1; i++){
				String firstpart = rest.substring(0, i+1);
				long thesum = Long.valueOf(firstpart) + Long.valueOf(sum);
				helper(splitRemain-1, thesum+"", rest.substring(i+1, rest.length()), first, firstpart);
			}
		}
		if(splitRemain == 0){
			if(sum.equals(rest)){
				System.out.println(first + "+" + second  + "=" + rest);
			}
			if(Long.valueOf(rest) + Long.valueOf(second) == Long.valueOf(first)){
				System.out.println(rest + "+" + second  + "=" + first);
			}
		}
	}
}