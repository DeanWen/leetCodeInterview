/*
 * Dian Wen
 * Median Array
 * 11/21/2014
 */

/* O(1) space, O(n^2) time*/
import java.util.*;

public class findMedian {
	public double[] medianArray(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		double[] result = new double[num.length];
		
		if (num.length == 1) {
			result[0] = num[0];
			return result;
		}
		
		result[0] = num[0];
		
		for (int i = 1; i < num.length; i++) {
			insert(num, i);
			if (i % 2 == 0) {
				System.out.println("Odd");
				result[i] = num[i / 2];
			} else {
				System.out.println("Even");
				result [i] = (num[i / 2] + num[i / 2 + 1]) * 1.0 / 2;
			}
		}
		return result;
	}
	
	private void insert (int[] num, int end) {
		if (num == null || num.length <= 1) {
			return;
		}
		
		for (int i = end - 1; i >= 0; i--) {
			if (num[i] >= num[i + 1]) {
				int temp = num[i + 1];
				num[i + 1] = num[i];
				num[i] = temp;
			} else {
				break;
			}
		}
		
	}
	
}
