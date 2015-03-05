import java.util.*;



//Write, efficient code for extracting uniqueelements from a sorted list of array. e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).



public class UniqueNumber {
	
	public void test(){
		int[] thenumbers = {1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9};
		List<Integer> result = sol(thenumbers);
			System.out.print(result);
	}
	
	public List<Integer> sol(int[] numbers){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < numbers.length - 1; i++){
			if(numbers[i] != numbers[i+1]){
				result.add(numbers[i]);
			}
		}
		result.add(numbers[numbers.length-1]);
		return result;
	}
	
	
	
}