/*
* Insertion Sort
*/

public void InsertionSort(int[] array) {
	for (int out = 0; out < array.length; out++) {
		int temp = array[out];
		int in = out;

		while (in > 0 && array[in - 1] >= temp) {
			array[in] = array[in-1];
			in--;
		}

		data[in] = temp;
	}
}
