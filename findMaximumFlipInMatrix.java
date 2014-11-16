/*
* Dian (Dean) Wen
* Nov. 15th, 2014
* Carnegie Mellon University
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class findMaximum {
    /*
    * Main thought:
    * Consider input character as 2D array or a matrix
    * Using first character of each row as a pivotal symbol
    * Using ArrayList to record all index of character which same to the pivotal symbol in each row
    * Using HashMap to record all index position and appearing times
    * If appear new index, put to map, else the increase index time
    * The result should be the maximum appearing times of same index position among the matrix 
    * The overall time complexity is O(m*n)
    */
    public static int findMaximumWishes(char[][] box) {
        if (box == null || box.length == 0 || box[0].length == 0) {
            return 0;
        }
        
		int m = box.length;
		int n = box[0].length;
		int max = 1; //At least 1 row in same after flip
		HashMap<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();
        
		/*The time complexity is O(m)*/
		for (int i = 0; i < m; i++) {
			ArrayList<Integer> position = new ArrayList<Integer>();
			char pivot = box[i][0];
			position.add(0);
		    
            /*The time complexity is O(n)*/
			for (int j = 1; j < n; j++) {
				if (box[i][j] == pivot) {
					position.add(j);
				}
			}

			/*The time complexity is O(1)*/
			if (!map.containsKey(position)) {
				map.put(position, 1);
			}else {
				map.put(position, map.get(position) + 1);
                /*If appearing same position, then compare with max, always keep the larger num*/
				max = max > map.get(position) ? max : map.get(position);
			}
		}
		
		return max;
	}
    
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
    	int m = in.nextInt();
    	int n = in.nextInt();
    	char[][] matrix = new char[m][n];
        
    	/*Read Test Case*/
    	for (int i = 0; i < m; i++) {
    		String tmp = in.next();
    		matrix[i] = tmp.toCharArray();
    	}
        
        int result = findMaximumWishes(matrix);
        System.out.print(result);
    }
}