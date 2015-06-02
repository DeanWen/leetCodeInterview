/*
[8,7,6,12,14]

you need to find 3 numbers such that a<b<c
  and i<j<k
  a,b,c are the values of the numbers
    i,j,k are the indices of the numbers
      
      for this case the answer could be 
      8,12,14   or
        7,12,14 or 
          6,12,14
                        
i want O(n) time. O(1) extra memory
*/


//Time Complexity O(n)
//Space Complexity O(1)
public class LIS {
	public static void getNumbers(int[] array) {
		if (array == null || array.length < 3) {
			return;
		}

		int first = array[0];
		int second = Integer.MIN_VALUE;
		int min = array[0];
		int third = Integer.MIN_VALUE;
		for (int i = 1; i < array.length; i++) {
			//find second number
			if (second == Integer.MIN_VALUE) {
				if (array[i] <= first) {
					first = array[i];
					min = array[i];	
				}else {
					second = array[i];
				}
			}else {// find third number
				if (array[i] > second) {
					third = array[i];
					System.out.println(first+ "," + second + "," + third);
					return;
				}else if (array[i] > min) {
					first = min;
					second = array[i];
				}else if (array[i] < second &&  array[i] > first) {
					second = array[i];
				}else if (array[i] < first) {
					min = array[i];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] t = {8, 7, 6, 9, 10};
		getNumbers(t);
	}
}