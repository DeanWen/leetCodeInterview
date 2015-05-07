package wordPatternII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
	
	public static boolean harderWordPattern(String s, String patternString) {
		if (s == null || s.length() == 0 || patternString == null || patternString.length() == 0) {
			return false;
		}
		String[] pattern = patternString.split(" ");
		List<String> path = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, Integer> patternMap = new HashMap<String, Integer>();
		return helper(path, s, pattern, 0, -1, map, patternMap);
		
	}
	
	public static boolean helper (List<String> path, String s, String[] pattern, int pos, int prePos, HashMap<String, String> map, HashMap<String, Integer> patternMap) {
		if (path.size() == pattern.length - 1) {
			if (isValid(map, patternMap, s.substring(pos, s.length()), pattern[pattern.length - 1])) {
				path.add(s.substring(pos, s.length()));
				return true;
			} else {
				return false;
			}
		}
		
		boolean rst = false;
		for (int i = pos; i < s.length(); i++) {
			String sub = s.substring(prePos + 1, i + 1);
			String p = pattern[path.size()];
			if (!isValid(map, patternMap, sub, p)) {
				continue;
			}
			
			map.put(sub, p);
			if (patternMap.containsKey(p)) {
				patternMap.put(p, patternMap.get(p) + 1);
			} else {
				patternMap.put(p, 1);
			}
			path.add(sub);
			rst |= helper(path, s, pattern, i + 1, i, map, patternMap);
			if (rst) break;
			path.remove(path.size() - 1);
			int count = patternMap.get(p) - 1;
			if (count > 0) {
				patternMap.put(p, count);
			} else {
				patternMap.remove(p);
				map.remove(sub);
			}
		}
		
		return rst;
		
	}
	
	public static boolean isValid (HashMap<String, String> map, HashMap<String, Integer> patternMap, String s, String pattern) {
		if (map.containsKey(s) && !map.get(s).equals(pattern)) {
			return false;
		}
		if (!map.containsKey(s) && patternMap.containsKey(pattern)) {
			return false;
		}
		return true;
	}
	
	
	
	public static boolean wordPatter(List<String> split, String[] pattern) {
		
		if (split.size() != pattern.length) {
			return false;
		}

		// string and pattern map
		HashMap<String, String> map = new HashMap<String, String>();
		// list the patter
		HashSet<String> patternSet = new HashSet<String>(); 
		for (int i = 0; i < split.size(); i++) {
			if (map.containsKey(split.get(i)) && !map.get(split.get(i)).equals(pattern[i]) ) {
				return false;
			} 
			if (!map.containsKey(split.get(i)) && patternSet.contains(pattern[i])) {
				return false;
			}
			map.put(split.get(i), pattern[i]);
			patternSet.add(pattern[i]);
		}
		
		return true;
		
	}
	
	public static void main (String[] args) {
		String s = "bluebluebluebluered";
		String patternString = "d d d d d";
		
		System.out.println(harderWordPattern(s, patternString));
	}
	

}
