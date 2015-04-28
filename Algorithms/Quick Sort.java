/*
* Quick Sort
*/

public static int partition (int[] array, int left, int right) {
	int pivot = array[(left + right) / 2];
	int i = left;
	int j = right;

	while (i < j) {
		while (array[i] < pivot) {
			i++;
		}
		while (array[j] > pivot) {
			j--;
		}

		if (i <= j) {
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
			i++;
			j--;
		}
	}

	return i;
}

public static void quickSort (int[] array, int left, int right) {
	int index = partition(array, left, right);
	if (left < index) {
		quickSort(array, left, index - 1);
	}
	if (right > index) {
		quickSort(array, index, right);
	}
}