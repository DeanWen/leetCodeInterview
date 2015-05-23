/*
Implement strStr() : https://leetcode.com/problems/implement-strstr/
Time Complexity : O(n)
Space Complexity : O(1)
Worst Case is every char in base need loop m times:
Base: 	aaaaa
Target: ac
*/
public class Solution {
    public int strStr(String base, String target) {
    	if (base == null || target == null) {
    		return -1;
    	}
    	if (base.isEmpty() && target.isEmpty()) {
    		return 0;
    	}
    
    	int i, j;
    	int diff = base.length() - target.length();
    	for (i = 0; i <= diff; i++) {
    		for (j = 0; j < target.length(); j++) {
    			if (base.charAt(i + j) != target.charAt(j)) {
    				break;
    			}
    		}
    		if (j == target.length()) {
    			return i;
    		}
    	}
    
    	return -1;
    }
}