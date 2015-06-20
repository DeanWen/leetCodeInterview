/**
* bubble sort
*/

public class BubbleSort {
	public static int[] bubbleSortAscending(int[] array) {
		for (int i = 0; i < array.length; i++ ) {
			for (int j = 1; j < array.length - i; j++){
				if (array[j-1] > array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}

		return array;
	}

	public static int[] bubbleSortDescending(int[] array) {
		for (int i = 0; i < array.length; i++ ) {
			for (int j = 1; j < array.length - i; j++){
				if (array[j-1] < array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}

		return array;
	}

	/*Main for Test*/
	public static void main(String[] args) {
		int[] array = new int [args.length];

		for(int i = 0; i < args.length; i++) {
			array[i] = Integer.parseInt(args[i]);
		}

		printOut(bubbleSortAscending(array));
		System.out.println();
		printOut(bubbleSortDescending(array));
		System.out.println();
	}

	public static void printOut(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+ " ");
		}
	}
}