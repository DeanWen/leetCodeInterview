import java.util.*;



//Write aprogram to display the advisered average for the list of numbers my omittingthe three largest number in the series. 

//E.g:3,6,12,55,289,600,534,900,172.  avg=(3+6+12+55+289+172) /6and eliminating534,900,600



public class AdviseredAverageNumber {
	
	public void test(){
		int[] thenumbers = {1,-2,-2,-4,-5,6};
		double result = sol(thenumbers);
			System.out.print(result);

	}
	
	public double sol(int[] numbers){
		if(numbers.length <= 3) return 0;
		
		Arrays.sort(numbers);
		double sum = 0.0;
		for(int i = 0; i < numbers.length - 3; i++){
			sum += numbers[i];
		}
		
		return sum/(numbers.length - 3);
	}
	
	
	
}