public class Solution {
	public static class Element {
		int value;
		int time;
		Element(Integer v, Integer t) {
			value = v;
			time = t;
		}
	}

	public static List<Integer> findTopK (int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		
		List<Element> list = new ArrayList<Element>();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry pair = (Map.Entry)iter.next();
		   	Element ele = new Element((Integer)pair.getKey(), (Integer)pair.getValue());
			list.add(ele);
		}

		PriorityQueue<Element> pq = new PriorityQueue<Element>(k + 1, new myComparator());
		for (Element e : list) {
			pq.offer(e);
			if (pq.size() >= k + 1) {
				pq.poll();
			}
		}
			
		for (Element e : pq) {
			res.add(e.value);
		}
		
		return res;
	}
	
	public static class myComparator implements Comparator<Element> {
		@Override
		public int compare (Element e1, Element e2) {
			return e1.time - e2.time;
		}
	}
	
	//Main Function for Test
	public static void main(String[] args) {
		int[] A = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5};
		System.out.println(Arrays.toString(A));
		
		List<Integer> res = findTopK (A, 3);

		for (Integer i : res) {
			System.out.print(i);
		}
	}
}