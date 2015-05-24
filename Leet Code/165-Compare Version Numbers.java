public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");
        
        int len = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < len; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            
            int result = v1.compareTo(v2);
            if (result != 0) {
                return result;
            }
        }
        
        return 0;
    }
}