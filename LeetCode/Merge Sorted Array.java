public class Solution {
   public void merge(int A[], int m, int B[], int n) {
        int index = m + n;//suppose if m+n space in A[]
        /*
        *when A B neither empty
        *compare from left to right;
        *put the bigger one to the right end
        *because sorted array, the order is
        * small -> large
        */
        while (m > 0 && n > 0) {
            //fisrt compare the last element m - 1 and n - 1
            //because the index starts from 0 to m-1
            if (A[m - 1] > B[n - 1]) {
                //using --index & --mm
                //means --first, then assign value;
                //so the start point is index - 1 to 0
                A[--index] = A[--m];
            } else {
                A[--index] = B[--n];
            }
        }

        /*
        *since the first loop condition is m > 0 && n > 0
        *n > 0 means m <= 0 fails condition means A is empty
        *when A is empty, then the rest of the elements should
        *be entirely from the rest of B[]
        *
        *we don't need to care about B is empty;
        *since we are merging B[] to A[]
        *if B[] is empty, the rest should be all from A[]
        *which are already there.
        */
        while (n > 0) {
            A[--index] = B[--n];
        }
    }
}