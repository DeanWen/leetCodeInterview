public class maximumProductArray {
	//Overall Time Complexity : O(n)
	public static int maxProductArray (int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		int min = arr[0];
		int max = arr[0];
		int res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int temp = max;
			max = Math.max(Math.max(arr[i] * max, arr[i] * min), arr[i]);
			min = Math.min(Math.min(arr[i] * temp, arr[i] * min), arr[i]);
			if (res < max) {
				res = max;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {-1,-2,3};
		System.out.println(maxProductArray(a));
	}
}
