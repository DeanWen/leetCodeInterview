public class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 1) {
			return arr;
		}
		
		/*First K section*/
		int[] res = new int[arr.length - k + 1];
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		
		/*The rest k - length section*/
		for (int i = k; i < arr.length; i++) {
			res[i - k] = arr[dq.peekFirst()];
			while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
				dq.pollLast();
			}
			while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
				dq.pollFirst();
			}
			dq.addLast(i);
		}
		
		res[arr.length - k] = arr[dq.pollFirst()];
		return res;
    }
}