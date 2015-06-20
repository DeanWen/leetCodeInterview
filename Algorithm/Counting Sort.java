/*
Counting sort is different from the normal sorting approach 
(like Merge Sort, Quick Sort, Heap sort etc.) 
generally known as comparison sort. 
The worst case for any comparison sort is O(n log(n)).

Counting sort does the sorting of elements in linear time O(n). 
Generally any sorting which can be accomplished in linear time makes some assumption on the data provided. 
In case of counting sort, The assumption made is that the max value in a given set of “n” items is “k”,
K is the temp array length, measn the max value;
(where k = O(n)) then the sort runs in linear time.
*/

public class Solution {
	public static int[] countingSort (int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int maxValue = getMax(array);
		int[] temp = new int[maxValue + 1];
		int[] res = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			temp[array[i]] += 1; 
		}

		for (int i = 1; i < temp.length; i++) {
			temp[i] = temp[i] + temp[i - 1];
		}

		/*
		* Must from tail to head
		* To keep STABLITY (element originally relative order)
		**/
		for (int i = array.length - 1; i >= 0; i--) {
			res[temp[array[i]] - 1] = array[i];
			temp[array[i]] = temp[array[i]] - 1;
		}

		return res;
	}

	public static int getMax (int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	/*Main for Test*/
	public static void main(String[] args){
		int[] arrayToSort = new int[] { 0, 3, 1, 0, 5, 2, 4, 5, 2 };
		int[] sortedArray = countingSort(arrayToSort);
	  	for (int i = 0; i < sortedArray.length; i++){
	   		System.out.print(sortedArray[i] + ",");
	  	}
 	}
}