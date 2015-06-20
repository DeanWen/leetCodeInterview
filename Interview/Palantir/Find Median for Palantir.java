/*
* Given an array of integers, return an array whose i－th value is the median 
* of the first i integers in the input
* i.e input = {1, 3, 5} return = {1, 2, 3}
*
* Can you do it in constant memory in O(n^2) or faster?
*/

import java.util.Arrays;

public class findMedian {
	//Time Complexity is O(n^2 log n)
	//Space Complexity is O(n^2);
	public static double[] findMedianInArray(int[] array) {
		if (array == null || array.length ==0) {
			return null;
		}

		double[] result = new double[array.length];
		
		//Time Complexity is O(n^2 log n)
		for (int i = 1; i <= array.length; i++) {
			int [] temp = Arrays.copyOf(array, i);
			result[i - 1] = calculate(temp);//O(n log n)
		} 
		
		return result;
	}

	//Time Complexity is O(n log n)
	public static double calculate(int[] array) {
		Arrays.sort(array);
		
		double median;
		if (array.length % 2 == 0) {
			median = (array[array.length / 2] + array[array.length / 2 - 1]) * 1.0 / 2;
		}else {
			median = array[array.length / 2];
		}

		return median;
	}

	public static void main (String[] args) {
		int[] array = {1, 4, 5, 7, 9};
		System.out.println(Arrays.toString(findMedianInArray(array)));
	}
}
