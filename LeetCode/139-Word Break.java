public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] result = new boolean[s.length() + 1];
        Arrays.fill(result, false);
        result[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String str = s.substring(j, i + 1);
                if (result[j] && dict.contains(str)) { //It's result[j] not i
                    result[i + 1] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}