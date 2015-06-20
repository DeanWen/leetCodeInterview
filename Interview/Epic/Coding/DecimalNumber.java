import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Let the user enter a decimal number. Therange allowed is 0.0001 to 0.9999. Only four decimal places are allowed. 
//Theoutput should be an irreducible fraction. 
//E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.



public class DecimalNumber {
	
	public void test(){
		sol(0.35);
		sol(0.9999);
		sol(0.99999);
	}
	
	public void sol(double check){
		if(check <= 0 || check >= 1){
			System.out.println("Range should be 0.0001 to 0.9999");
			return;
		}
		if(check > (double)((int)(check*10000))/10000){
			System.out.println("Four decimal places are allowed");
			return;
		}
		
		double top = check*10000;
		double buttom = 10000;
		
		double common = this.getCommonDivisor(top, buttom);
		
		System.out.println((int)(top/common) + "/" + (int)(buttom/common));
	}
	
	public double getCommonDivisor(double m, double n){
		double bigger = m;
		double smaller = n;
		if(m < n){
			bigger = n;
			smaller = m;
		}
		double remain = bigger%smaller;
		if(remain == 0){
			return smaller;
		}else{
			return getCommonDivisor(smaller, remain);
		}
	}
}