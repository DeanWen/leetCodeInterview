import java.util.*;



//There is one kind of numbers call FibbonaciNumber, which satisfy the following situation:
//
//A. can be spilt into several numbers;
//
//B. The first two number are the same, thenext number is equal to the sum of previous two
//
//eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
//If you are given a range by the user, findall numbers that are Fibbonaci numbers.

public class FibbonaciNumber {

	public void sol(int from, int to){
		
		
		for(int i = 1; true; i++){
			String result = "";
			result += i;
			result += i;
			int first = i;
			int second = i;
			
			int nextnum = first+second;
			result += nextnum;
			long intresult = Long.valueOf(result);
			if(intresult > to) break;
			if(intresult >= from) System.out.println(result);
			
			while(true){
				first = second;
				second = nextnum;
				nextnum = first + second;
				result += nextnum;
				intresult = Long.valueOf(result);
				if(intresult >= from && intresult <= to){
					System.out.println(result);
				}
				if(intresult > to){
					break;
				}
			}
		}
	}
}