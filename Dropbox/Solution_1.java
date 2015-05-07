package buyCokeII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static int getCount(int num, List<Integer> list, int pos) {
		if (pos >= list.size()) {
			return 0;
		}
		if (pos == list.size() - 1) {
			return 1;
		}
		int count = 0;
		for (int i = 0; i <= num / list.get(pos); i++) {
			count += getCount(num - i * list.get(pos), list, pos + 1);
		}
		return count;
	}

	public static void main (String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(5);
		list.add(1);
		System.out.println(getCount(5, list, 0));
	}
	
}
