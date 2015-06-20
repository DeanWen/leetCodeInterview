/*
* Shift an Array k places in O(n) time and O(1) space

The Idea
Reverse a to get ar b.
Reverse b to get ar br .
Reverse all to get (ar br )r = ba.
The Code // rotate abcdefgh left three 
reverse(0, d-1) // cbadefgh 
reverse(d, n-1) // cbahgfed 
reverse(0, n-1) // defghabc 

*/

public static void shiftKthInArray(char[] array, int k) {
	if (array == null || array.length == 0 || k %= array.length == 0) {
		return;
	}
	if (k > array.length) {
		k = k % array.length;
	}

	reverse(array, 0, array.length - 1);
	reverse(array, 0 , k -1);
	reverse(array, k, array.length - 1);
}

public static void reverse(char[] array, int start, int end){	
	 int mid = 	start + (end - start) / 2;
	 for (int i = start; i <= mid; i++) {
	 	char temp = array[i];
	 	array[i] = array[end - (i - start)];
	 	array[end - (i - start)] = temp;
	 }
}