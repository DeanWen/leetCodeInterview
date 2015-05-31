/*
第一题是给一个String，如果有multiple space只保留一个，
比如" I love    this game    !    ", 应该要return " I love this game ! "，
就是traverse一遍这个String，设一个prevv，然后进行比较就行了
*/

//Time Complexity : O(n)
//Space Complexity : O(1)

public class Solution {
	public static void main(String[] args) {
		System.out.println(removeMulSpace(" I love    this game    !    "));
	}
	
	public static String removeMulSpace (String origin) {
		if (origin == null || origin.isEmpty()) {
			return origin;
		}

		StringBuilder sb = new StringBuilder();
		int prev = 0;
		for (int curr = 1; curr < origin.length(); curr++) {
			if (Character.isWhitespace(origin.charAt(prev)) &&
				Character.isWhitespace(origin.charAt(curr))) {
				continue;
			} 
			sb.append(origin.charAt(prev));
			prev = curr;
		}
		
		sb.append(origin.charAt(prev));
		return sb.toString();
	}
}