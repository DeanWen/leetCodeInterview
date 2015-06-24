import java.util.PriorityQueue;
public class ConnectSticks {
	public static int getMinval(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (Integer i : arr) {
			pq.offer(i);
		}

		int cost = 0;
		while (pq.size() > 1) {
			Integer least1 = pq.poll();
			Integer least2 = pq.poll();
			Integer combined = least1 + least2;
			cost += combined;
			pq.offer(combined);
		}

		return cost;
	}
	
	public static void main(String[] args) {
		int[] arr = {186,64,35,32,103};
		System.out.print(getMinval(arr));
	}
}

