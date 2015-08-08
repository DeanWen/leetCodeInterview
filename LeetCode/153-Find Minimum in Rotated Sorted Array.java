public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;    
        }
        
        int start = 0;
        int end = num.length-1;
        if (num[start] < num[end]) 
            return num[0];

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[start] < num[mid]) 
                start = mid;
            else
                end = mid;
        }
    
        return num[end];
    }
}