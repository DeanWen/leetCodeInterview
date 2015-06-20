import java.util.*;



//Find the largest sum contiguous sub array. The length of the returned sub array must beat least of length 2.



public class LargestSumSubArray {
	
	public void test(){
		int[] thenumbers = {1,-2,-2,-4,-5,6};
		int[] result = sol(thenumbers);
		for(int ele: result){
			System.out.print(ele + " ");
		}

	}
	
	public int[] sol(int[] numbers){
		if(numbers.length < 2) return null;
		if(numbers.length == 2) return numbers;
		
		int currentMax = numbers[0] + numbers[1];
		int maxSoFar = currentMax;
		int start = 0;
		int tail = 1;
		
		for(int i = 2; i < numbers.length; i++){
			if(numbers[i] + numbers[i - 1] > currentMax + numbers[i]){
				currentMax = numbers[i] + numbers[i-1];
					start = i-1;
					tail = i;
			}else{
				currentMax += numbers[i];
				tail = i;
			}
			//maxSoFar = Math.max(currentMax, maxSoFar);
		}
		
		int[] result = new int[tail-start + 1];
		
		for(int i = 0; i < result.length; i ++, start++){
			result[i] = numbers[start];
		}
		
		return result;
	}
	
	
	
}