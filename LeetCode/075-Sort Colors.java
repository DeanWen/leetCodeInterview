/*
* Two Pointer 1 pass && Constant space
*	Time Complexity O(n)
*	Space Complexity O(1)
*/
public class Solution {
    public void sortColors(int[] A) {
        if(A == null || A.length == 0) {
            return;
        }
        
        int leftBound = 0;
        int rightBound = A.length - 1;
        int i = 0;
        while(i <= rightBound) {
        	/*
        	*leftBound always points next not 0
        	*move leftBound and i together
        	*the swaped value can only be 1
        	*because i is ahead of left, if meet 2
        	*it has to be already swaped to right
        	*/
            if (A[i] == 0) {
                swap(A, leftBound, i);
                leftBound++;
                i++;
            }else if(A[i] == 1) {
                i++;
            }else {
                swap(A, rightBound, i);
                rightBound--;
                //not move i, since need to check the swaped value
            }
        }
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

/*
* Counting Sort - Extra Space && 4 times loop
*	Time Complexity O(n)
*	Space Complexity O(n)
*/
public class Solution {
    public void sortColors(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}

		int[] temp = new int[3];
		int[] res = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			temp[array[i]] += 1; 
		}

		for (int i = 1; i < temp.length; i++) {
			temp[i] = temp[i] + temp[i - 1];
		}

		for (int i = array.length - 1; i >= 0; i--) {
			res[temp[array[i]] - 1] = array[i];
			temp[array[i]] -= 1;
		}
        
        for (int i = 0; i < array.length; i++) {
            array[i] = res[i];
        }
    }
}