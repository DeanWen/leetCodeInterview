import java.util.*;

/*
 * sliding windows (given an array of n numbers and a window width of k , return a new array 
 * with the minimum value in each window)
 * e.g: a = 1,2,3,-1,5,6,7
 * k = 3 return : 1,-1,-1,-1,5,6,7;
 */
public class SlidingWindow {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -1, 5, 6, 7 };
		int k = 3;
		int[] res1 = slideWindow(arr, k);
		int[] res2 = slideWindow2(arr, k);
		System.out.println(Arrays.toString(res1));
		System.out.println(Arrays.toString(res2));
	}

	// Overall Time Complexity: O(nk)
	public static int[] slideWindow(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 1) {
			return arr;
		}

		int[] res = new int[arr.length];
		// O(n)
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			// O(k)
			for (int j = i; j < i + k && j < arr.length; j++) {
				min = Math.min(arr[j], min);
			}
			res[i] = min;
		}

		return res;
	}
	
	// Overall Time Complexity: O(n)
	// Every digit only insert or delete once, total is 2n
	public static int[] slideWindow2(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 1) {
			return arr;
		}
		
		/*First K section*/
		int[] res = new int[arr.length];
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && arr[i] <= arr[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		
		/*The rest k - length section*/
		for (int i = k; i < arr.length; i++) {
			res[i - k] = arr[dq.peekFirst()];
			while (!dq.isEmpty() && arr[i] <= arr[dq.peekLast()]) {
				dq.pollLast();
			}
			while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
				dq.pollFirst();
			}
			dq.addLast(i);
		}
		
		/*assign the rest to res*/
		for (int i = arr.length - k; i < arr.length; i++) {
			res[i] = arr[dq.peekFirst()];
			dq.pollFirst();
		}
		
		return res;
	}
}