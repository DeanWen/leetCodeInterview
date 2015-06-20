/*
Hackerrank.com
Find the longest palidromic substring
Using dynamic programming skills
*/

public class Solution {
    public static void longestPalindrome(String s) {
        if(s == null || s.length()==0)
            return;
        boolean[][] palin = new boolean[s.length()][s.length()];
        String result = "";
        int maxLen = 0;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || palin[i+1][j-1])) {
                    palin[i][j] = true;
                    if(maxLen<j-i+1) {
                        maxLen=j-i+1;
                        result = s.substring(i,j+1);
                    }
                }
            }
        } 
    
        System.out.println(result.length());
    }
    
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int num = in.nextInt();
        while (num-- >= 0) {
        	longestPalindrome(in.nextLine());
        }
    }
}