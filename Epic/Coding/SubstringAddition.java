import java.util.*;


//
//Write a program to add the substring 
//eg :say you have a list {1 7 6 3 5 8 9 } and user is entering a sum 16.Output should display (2-4) that is {7 6 3} cause 7+6+3=16.


public class SubstringAddition {
	
	public void test(){
		int[] A = {1, 2, 3, 4, 5};
		int[] B = {4,5,3,5};
		
		sol(A,7);

	}
	
	public void sol(int[] A, int sum){
		int[] dp = new int[A.length];
		int cum = 0;
		for(int i = 0; i < dp.length; i++){
			cum += A[i];
			dp[i] = cum;
		}
		
		for(int i = 0; i < A.length; i++){
			for(int j = i+1; j < A.length; j++){
				if(dp[j]-dp[i] == sum){
					System.out.println((i+1) + "to" + j);
				}
			}
		}
	}
	
	
	
}