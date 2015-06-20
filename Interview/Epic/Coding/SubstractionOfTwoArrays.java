import java.util.*;


//
//Suppose you want to do the subtraction of twonumbers. Each digit of the numbers is divided and put in an array. 
//Like A=[1,2, 3, 4, 5], B=[4, 5, 3, 5]. You should output an array C=[7, 8, 1, 0].
//Remember that your machine can¡¯t hand numbers larger than 20.

//Assume A is bigger than B

public class SubstractionOfTwoArrays {
	
	public void test(){
		int[] A = {1, 2, 3, 4, 5};
		int[] B = {4,5,3,5};
		
		int[] result = sol(A,B);

		for(int ele: result){
			System.out.print(ele + " ");
		}
	}
	
	public int[] sol(int[] A, int[] B){
		if(A.length > 20 || B.length >20){
			System.out.println("the machine can't handle numbers larger than 20");
		}
		
		int borrow = 0;
		
		for(int i = A.length - 1, bPointer = B.length-1; i >= 0; i--,bPointer--){
			int aint = A[i];
			int bint = 0;
			if(bPointer >= 0){
				bint = B[bPointer];
			}
			
			aint -= borrow;
			borrow = 0;
			
			if(aint < bint){
				aint += 10;
				borrow = 1;
			}
			
			A[i] = aint - bint;
		}
		return A;
	}
	
	
	
}