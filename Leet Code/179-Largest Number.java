/*
** Customize the String Comparator
** to compare s1.concat(s2) && s2.concat(s1)
**
**  Time Complexity O(nlogn)
**  Space Complexity O(n)
*/

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        /*convert to string array*/
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        
        /*sort array based on cutomized comparator*/
        Arrays.sort(numStr, new myComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStr.length; i++) {
            sb.append(numStr[i]);
        }
        
        /*remove heading O-s*/
        String res = sb.toString();
        int i = 0;
        while (i < res.length() - 1 && res.charAt(i) == '0') {
            res = res.substring(i + 1);
        }
        
        return res;
    }
    
    public class myComparator implements Comparator<String> {
        @Override
        public int compare (String o1, String o2) {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        }
    }
}