/*

	Corner Cases:

	i. needle or haystack is empty. If needle is empty, always return 0. If haystack is
	empty, then there will always be no match (return –1) unless needle is also
	empty which 0 is returned.

	ii. needle’s length is greater than haystack’s length. Should always return –1.

	iii. needle is located at the end of haystack. For example, “aaaba” and “ba”. Catch
	possible off-by-one errors.

	iv. needle occur multiple times in haystack. For example, “mississippi” and
	“issi”. It should return index 2 as the first match of “issi”.

	v. Imagine two very long strings of equal lengths = n, haystack = “aaa…aa” and
	needle = “aaa…ab”. You should not do more than n character comparisons, or
	else your code will get Time Limit Exceeded in OJ.
     
*   Time Complexity : O(nm)
*   Space Complexity : O(1)
*/
public class Solution {
    public int strStr(String haystack, String needle) {
    	for (int i = 0; ; i++) {
    		for (int j = 0; ; j++) {
    			if (j == needle.length()) {
    				return i;
    			}
    			if (i + j == haystack.length()) {
    				return -1;
    			}
    			if (needle.charAt(j) != haystack.charAt(i + j)) {
    				break;
    			}
    		}
    	}
    }
}

/*
* Solution 2
* output string
*/
public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return null;
        }
        int i, j;
        for(i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for(j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == needle.length()) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}