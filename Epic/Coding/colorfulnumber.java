import java.util.*;


//If given a number find a number if it is colorful. A number is said to be colorful if all its possible unique permutations multiplication result different. 
//Eg: if n = 1234 then permutations are (1,2),(1,3),(1,4), (2,3),(2,4),(3,4),(1,2,3), (1,2,4), (2,3,4). That's it, no other combination. Find the multiplication of digits in each combination and if any of them repeats then number is not colorful.
//


public class colorfulnumber {

	HashSet theset = new HashSet();
	
	public boolean colorfulnumber(int num){
		String numString = num + "";
		
		if(numString.length() == 1) return true;
		
		return helper(numString, 0, new ArrayList<Integer>());
	}
	
	public boolean helper(String numString, int pointer, List<Integer> permutations){
		int len = numString.length();
		for(int i = pointer; i < len; i ++){
			char curr = numString.charAt(i);
			int digit = Character.getNumericValue(curr);
			permutations.add(digit);
			int product = permutations.get(0);
			for(int j = 1; j < permutations.size(); j++){
				product *= permutations.get(j);
			}
			if(!theset.add(product)) return false;
			if(!helper(numString, i+1, permutations)) return false;
			permutations.remove(permutations.size()-1);
		}
		return true;
	}
}