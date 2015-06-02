/*
Problem statement
You are given N subsequences(not necessarily contiguous) of a string. 
Find the shortest possible string which has distinct lower case letters, 
with the given subsequences. The solution is guaranteed to exist. 

Input

The first line has the value of N, 
followed by N lines containing each of the N subsequences of the solution string.

Each subsequence has distinct lower case letters

1<=N<=100000

Output

Output the value of the solution string.

Example

Input:
2
acd
bc

Output:
abcd

second test case  
Input:
3
ac
dbe
dea

Output:
dbeac
*/

import java.util.*;
public class ShortestCommonSuperstring {
	public static void toposort(Map<Character, Set<Character>> map,
			Set<Character> visited, Stack<Character> stack, char c) {
		visited.add(c);
		if (map.get(c) != null) {
			for (Character neigbor : map.get(c)) {
				if (!visited.contains(neigbor)) {
					toposort(map, visited, stack, neigbor);
				}
			}
		}
		stack.push(c);
	}

	public static String findOrder(List<String> strs) {
		Map<Character, Set<Character>> map = new HashMap<>();
		Set<Character> set= new HashSet<>();
		Set<Character> visited= new HashSet<>();
		for (String s : strs) {
			set.add(s.charAt(0));
			for (int i = 1; i < s.length(); i++) {
				if (!map.containsKey(s.charAt(i - 1))) {
					Set<Character> adjacent = new HashSet<>();
					adjacent.add(s.charAt(i));
					map.put(s.charAt(i - 1), adjacent);
				}else {
					map.get(s.charAt(i - 1)).add(s.charAt(i));
				}
				set.add(s.charAt(i));
			}
		}
		
		Stack<Character> stack = new Stack<>();
		for (char c : set) {
			if (!visited.contains(c)){
				toposort(map, visited, stack, c);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ac");
		list.add("dbe");
		list.add("dba");
		
		String res = findOrder(list);
		System.out.println(res);
	}
}