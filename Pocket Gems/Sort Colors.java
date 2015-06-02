import java.util.Arrays;
import java.util.Comparator;
public class SortColor {
    public enum Color {
        RED(0),
        WHITE(1),
        BLUE(2);
        private int value;
        Color(int x) {
            this.value = x;
        }
    }
    
    public static void swap (Color[] arr, int i, int j) {
        Color temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static class myComparator implements Comparator<Color> {
        @Override
        public int compare(Color o1, Color o2) {
            return o1.value - o2.value;
        }
    }
    
    //O(nlogn)
    public static void sort2(Color[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }   
        Arrays.sort(arr, new myComparator());
    }
    
    //O(n)
    public static void sort(Color[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        
        int leftBound = 0;
        int rightBound = arr.length - 1;
        int pointer = 0;
        while (pointer <= rightBound) {
            if (arr[pointer].value == 0) {
                swap(arr, leftBound, pointer);
                leftBound++;
                pointer++;
            }else if (arr[pointer].value == 1){
                pointer++;
            }else if (arr[pointer].value == 2) {
                swap(arr, rightBound, pointer);
                rightBound--;
            }
        }
    }
    
    public static void main(String[] args) {
        Color[] t = {Color.BLUE, Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE};
        sort(t);
        for (Color c : t) {
            System.out.print(c + ", ");
        }
    }
}