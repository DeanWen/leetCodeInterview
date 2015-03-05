import java.util.*;

//Take a series of integers as input till azero is entered. Among these given integers, 
//find the maximum of the oddnumbers and the minimum of the even integers (not including zero) and printthem.

public class FindMaxAndMin {

	public void test() {
		this.sol();
	}

	public void sol() {
		Scanner in = new Scanner(System.in);
		int maxOdd = Integer.MIN_VALUE;
		int minEven = Integer.MAX_VALUE;
		while (true) {
			if(!in.hasNextInt()){
				System.out.println("please input numbers!");
				in.next();
				continue;
			}
			int curr = in.nextInt();
			if(curr == 0) break;
			if(curr%2 == 0){
				minEven = Math.min(curr, minEven);
			}
			if(curr % 2 == 1){
				maxOdd = Math.max(maxOdd, curr);
			}
		}
		String maxOddString = (maxOdd == Integer.MIN_VALUE)?"No Odd Number was inputted":(maxOdd+"");
		String minEvenString = (minEven == Integer.MAX_VALUE)?"No Even Number was inputted":(minEven+"");
		
		System.out.println("The max odd number is:" + maxOddString);
		System.out.println("The min even number is:" + minEvenString);
	}

}