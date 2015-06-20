package wordPattern;

import java.util.HashMap;

public class Solution {
	
	public static boolean wordPatter(String s, String patternString) {
		if (s == null || s.length() == 0 || patternString == null || patternString.length() == 0) {
			return false;
		}
		
		String[] pattern = patternString.split(" ");
		String[] split = s.split(" ");
		if (split.length != pattern.length) {
			return false;
		}

		// string and pattern map
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < split.length; i++) {
			if (map.containsKey(split[i]) && !map.get(split[i]).equals(pattern[i]) ) {
				return false;
			} 
			if (!map.containsKey(split[i]) && map.containsValue(pattern[i])) {
				return false;
			}
			map.put(split[i], pattern[i]);
		}
		
		return true;
		
	}
	
	public static void main (String[] args) {
		String s = "red red red red";
		String patternString = "a b b a";
		
		System.out.println(wordPatter(s, patternString));
	}
	
}
