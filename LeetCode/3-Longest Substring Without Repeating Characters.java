/*
* Using character ASCII code as key.
* Using value as position.
* Time Complexity: O(n)
* Space Complexity: O(1) constant space
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[256];//constant space
        Arrays.fill(charMap, -1);
        
        int i = 0;
        int maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            /*
            *  Since initial is -1
            *       once found it assign to its position j
            *  if >= i means this is duplicate.
            *  keep the maximum length
            */
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        
        return maxLen;
    }
}