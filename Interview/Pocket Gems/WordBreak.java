import java.util.*;
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		//Time Complexity O(n^2)
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				String str = s.substring(j, i + 1);
				if (res[j] && dict.contains(str)) {
					res[i + 1] = true;
					break;
				}
			}
		}
		
		return res[s.length()];
	}
	
	public static ArrayList<String> wordBreakII(String s, Set<String> dict) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }

    public static ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s)) {
        	return memo.get(s);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0) {
        	return result;
        }
        
        for(int len = 1; len <= n; ++len){
            String subfix = s.substring(0, len);
            if(dict.contains(subfix)) {
                if(len == n) {
                    result.add(subfix);
                }else{
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item : tmp){
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
	
	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> set = new HashSet<>();
		set.add("leet");
		set.add("code");
		
		for (String str : wordBreakII(s, set)) {
			System.out.println(str);
		}
	}
}
