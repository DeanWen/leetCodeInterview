/*
* Solution Description
* http://www.cnblogs.com/springfor/p/3861890.html
*/
public class Solution {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;

        //Even && Odd Judgement
        if (total % 2 == 0) {
        	/*index is 0 based from 0 ~ (m|n - 1)
        	 *Kth is 1 based from 1 ~ K
        	 *Integer division is floor, so Kth should + 1
        	 */   
        	double x = findKth(A, 0, m - 1, B, 0, n - 1, total / 2);
        	double y = findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
        	return (x + y) / 2;
        }else {
        	return findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
        }
    }

    private static double findKth(int[] A, int astart, int aend, int[] B,
    	int bstart, int bend, int k) {
    	int m = aend - astart + 1;
    	int n = bend - bstart + 1;

    	/*
    	* Recursion Stop Condition
    	* m == 0;
    	* k == 1;
    	*/

    	if (m > n) {//always keep short first
    		return findKth(B, bstart, bend, A, astart, aend, k);
    	}else if (m == 0) {
    		return B[k - 1];//Kth index should minus 1
    	}else if (k == 1) {
    		return Math.min(A[astart], B[bstart]);
    	}

    	int partA = Math.min(k / 2, m);
    	int partB = k - partA;

    	if (A[astart + partA - 1] < B[bstart + partB - 1]) {
    		return findKth(A, astart + partA, aend, B, bstart, bend, k - partA);
    	}else if (A[astart + partA - 1] > B[bstart + partB - 1]) {
    		return findKth(A, astart, aend, B, bstart + partB, bend, k - partB);
    	}else {
    		return A[astart + partA - 1];
    	}
    	
    }
}