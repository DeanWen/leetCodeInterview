import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Please write a function that accepts a floating number and returns its square-root. 
//You may not use built-in square root function from your language.
//However, basic operators like addition, subtraction, multiplication are allowed. 
//Please take into consideration the floating precision.



public class Sqrt {
	
	public void test(){
		int newString = sol(5);
		System.out.println(newString);
	}
	
	public int sol(double x){
		if(x==0) return 0;
		
		double last = 0;
		int res = 1;
		
		while(res != last){
			last = res;
			res = (int) ((res + x/res)/2);
		}
		
		return res;
	}
	
	
}