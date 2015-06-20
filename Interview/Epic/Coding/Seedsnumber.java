import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Find the seed of a number. . 
//Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. find all possible seedfor a given number

//Attention: smallest seed number is the sqrt of the num. since for example 143*1*4*3 (143 > 1*4*3)
//unless the number is 0. it's seed number can never contains 0

public class Seedsnumber {

	public void test() {
		List<Integer> res = sol(1716);
		System.out.println(res);
	}

	public List<Integer> sol(int num) {
		List<Integer> result = new ArrayList<Integer>();
		if(num == 0){
			result.add(0);
			return result;
		}
		int sqrt = (int) Math.sqrt(num);
		outerloop: for (int i = sqrt; i <= num; i++) {
			int seed = i;
			int temp = i;
			if(num%seed == 0){
				int product = 1;
				while(temp != 0){
					int remain = temp%10;
					if(remain == 0) continue outerloop;
					product *= remain;
					temp /= 10;
				}
				product *= seed;
				if(product == num){
					result.add(seed);
				}
			}
		}
		return result;
	}

}