/*
* The Idea
* [1,2,3,4,5]   k = 2
*  reverse (0, n - 1) 54321
*  reverse (0, k - 1) 45321
*  reverse (k, n - 1) 45123 
*
*   Time Complexity : O(n) 
*   Space Complexity : O(1)
*/
public class Solution {
    public static void rotate(int[] array, int k) {
    	if (array == null || array.length == 0 || k % array.length == 0) {
    		return;
    	}
    	if (k > array.length) {
    	    k = k % array.length;
    	}
    	
    	reverse(array, 0, array.length - 1);
    	reverse(array, 0 , k - 1);
    	reverse(array, k, array.length - 1);
    }

    public static void reverse(int[] array, int start, int end){
         int mid = start + (end - start) / 2;
    	 for (int i = start; i <= mid; i++) {
    	 	int temp = array[i];
    	 	array[i] = array[end - i + start];
    	 	array[end - i + start] = temp;
    	 }
    }
}