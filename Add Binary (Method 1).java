/**
 * Add Binary Method 1
 * Case 1  l1 != null && l2 != null
 * Case 2  l1 != null
 * Case 3  l2 != null 
 * Remember to take care of the last carry-on
 */

public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int pa = a.length()-1;
        int pb = b.length()-1;
        int carries = 0;
        String rst = "";
        
        while(pb >= 0){
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
            pb --;
        }
        
        while(pa >= 0){
            int sum = (int)(a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }       
        
        if (carries == 1)
            rst = "1" + rst;
        return rst;
    }
}