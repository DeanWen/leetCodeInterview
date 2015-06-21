/*
* Longest Palindromic Substring 
*
* Method 1 DP
* 基本思路是外层循环i从后往前扫，内层循环j从i当前字符扫到结尾处。
* 过程中使用的历史信息是从i+1到n之间的任意子串是否是回文已经被记录下来，
* 所以不用重新判断，只需要比较一下头尾字符即可。
* 	Time Complexity : O(n^2)
*	Space Complexity : O(n^2)

定义函数
P[i,j] = 字符串区间[i,j]是否为palindrome.

首先找个例子，比如S="abccb",
  S   = a  b  c  c  b
Index = 0  1  2  3  4

P[0,0] = true  //each char is a palindrome
P[0,1] = S[0] == S[1], P[1,1] =1 
P[0,2] = S[0] == S[2] && P[1,1], P[1,2] = S[1] == S[2] , P[2,2] = 1
P[0,3] = S[0] == S[3] && P[1,2], P[1,3] = S[1] == S[3] && P[2,2] , P[2,3] =S[2] ==S[3],  P[3,3]=1       
......................
由此就可以推导出规律

P[i,j] =  true  if i == j
       =  S[i] == S[j]   if j = i + 1
       =  S[i] == S[j] && P[i+1][j-1]  if j > i + 1
*/
public class Solution {
    public String longestPalindrome(String s) {
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
}

/* 
* Method 2 Expanding from the middle
* 	Time Complexity : O(n^2)
*	Space Complexity : O(1)
*	是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,
	或者是ab的间隙，bc的间隙，例如aba是回文，abba也是回文，这两种情况要分情况考虑）
	往两边同时进 行扫描，直到不是回文串为止。假设字符串的长度为n,
	那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。
	对于每个中心往两边扫描的复杂 度为O(n),
	所以时间复杂度为O((2*n-1)*n)=O(n^2),
	空间复杂度为O(1)
*/

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return null;
        }
     
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
     
        return longest;
    }
     
    // Given a center, either one letter or two letter, 
    // Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
