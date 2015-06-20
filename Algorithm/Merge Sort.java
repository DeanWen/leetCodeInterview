/*
* Merge Sort
*/

public static int[] mergeSort (int[] array) {
	if (array == null || array.length <= 1) {
		return array;
	}
	int length = array.length;
	int[] left = new int[length / 2];
	int[] right = new int[length - length / 2];


	System.arraycopy(array, 0, left, 0, length/2);
    System.arraycopy(array, length/2, right, 0, length - length/2);

    // call itself to sort left half
    left = mergeSort(left);
    right = mergeSort(right);

	return merge(left, right);
}

public static int[] merge (int[] left, int[] right) {
	int length = left.length + right.length;
	int[] result = new int[length];
	int leftPtr = 0;
	int rightPtr = 0;
	int resultPtr = 0;

	while (leftPtr < left.length && rightPtr < right.length) {
		if (left[leftPtr] < right[rightPtr]) {
			result[resultPtr++] = left[leftPtr++];
		}else {
			result[resultPtr++] = right[rightPtr++];
		}
	}

	while (leftPtr < left.length || rightPtr < right.length) {
		if (leftPtr < left.length) {
			result[resultPtr++] = left[leftPtr++];
		}else {
			result[resultPtr++] = right[rightPtr++];
		}
	}

	return result;
}

