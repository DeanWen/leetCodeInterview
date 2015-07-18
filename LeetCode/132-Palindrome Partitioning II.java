public class Solution {
    public int minCut(String s) {  
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int[] cuts = new int[len + 1];
        boolean[][] matrix = new boolean[len][len];
        
        for (int i = 0; i <= len; i++) {
            cuts[i] = len - i - 1;
        }
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if ((s.charAt(i) == s.charAt(j) && j - i < 2 ) || 
                    (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1])) {
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        
        return cuts[0];
    }
}