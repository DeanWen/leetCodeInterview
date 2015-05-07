package buyCoke;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	// use 10, 5, 1 to get the how many combination there is to get the total num
	// eg. 20 = 1+1+1...+1(20) = 1+1+...+1(15) + 5 = 1+1+..+1(10)+5+5 ....
	public static List<List<Integer>> getCount(int num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		
		helper(path, result, num, 0);
		
		return result;
		
	}
	
	public static void helper (List<Integer> path, List<List<Integer>> result, int num, int sum) {
		if (sum > num) {
			return;
		}
		if (sum == num) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		if (path.isEmpty() || path.get(path.size() - 1) <= 10) {
			path.add(10);
			helper(path, result, num, sum + 10);
			path.remove(path.size() - 1);
		}
		if (path.isEmpty() || path.get(path.size() - 1) <= 5) {
			path.add(5);
			helper(path, result, num, sum + 5);
			path.remove(path.size() - 1);
		}
		if (path.isEmpty() || path.get(path.size() - 1) <= 1) {
			path.add(1);
			helper(path, result, num, sum + 1);
			path.remove(path.size() - 1);
		}
		
	}
	
	public static void main (String[] args) {
		int num = 20;
		List<List<Integer>> result = getCount(num);
		
		for (List<Integer> list : result) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
