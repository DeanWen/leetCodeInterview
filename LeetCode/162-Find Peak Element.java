public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null) {
            return 0;
        }
        return helper(0, num.length - 1, num); 
    }
    
    private int helper(int start, int end, int[] num) {
        if (start == end) {
            return start;
        }else if (start + 1 == end) {
            return num[start] > num[end] ? start : end;
        }else {
            int mid = start + (end - start) / 2;
            
            if (num[mid - 1] < num[mid] && num[mid] > num[mid + 1]) {
                return mid;
            }else if (num[mid - 1] < num[mid] && num[mid] < num[mid + 1]) {
                return helper(mid + 1, end, num);
            }else {
                return helper(start, mid - 1, num);
            }
        }
    }
}