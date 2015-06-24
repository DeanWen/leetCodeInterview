public class LongestPalindromicSubstring {
	//Overall Time Complexity is O(n^2)
	public static String findLPS (String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			//given a center i such as abbcbba
			String temp = helper(s, i, i);
			if (temp.length() > longest.length()) {
				longest = temp;
			}
			//given a center i, i + 1 such as abbccbba
			temp = helper(s, i, i + 1);
			if (temp.length() > longest.length()) {
				longest = temp;
			}
		}
		return longest;
	}
	
	private static String helper(String s, int begin, int end) {
		while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end))  {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	//DP approach 
	//Overall Time Complexity is O(n^2)
    public static String findLPS2(String s) {
    	if (s == null || s.length() == 0) {
    		return null;
    	}

    	boolean[][] isPalin = new boolean[s.length()][s.length()];
    	String res = "";
    	int max = 0;
    	for (int i = s.length() - 1; i >= 0; i--) {
    		for (int j = i; j < s.length(); j++) {
    			if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalin[i + 1][j - 1])) {
    				isPalin[i][j] = true;
    				if(max < j - i + 1){
    					max = j - i + 1;
    					res = s.substring(i, j + 1);
    				}
    			}
    		}
    	}

    	return res;
    }
	
	public static void main(String[] args) {
		String s = "abbxbbacthzj";
		System.out.println(findLPS(s));
		System.out.println(findLPS2(s));
	}
}
