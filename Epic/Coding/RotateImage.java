import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//leet code



public class RotateImage {
	
	public void test(){
		int[][] data = {{1,2},{3,4}};
		this.sol(data);	
		System.out.println();
	}
	
	public void sol(int[][] matrix) {
        if(matrix.length < 2) return;
    
        rotate90(matrix);
    }
    
    public void rotate90(int[][] matrix){
        this.transpose(matrix);
        this.reverseRow(matrix);
    }
    
    public void transpose(int[][] matrix){
        int n  = matrix.length;
        for(int i = 0; i < matrix.length - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                swap(matrix, i,j, n-1-j, n-1-i);
            }
        }
    }
    
    public void reverseRow(int[][] matrix){
        int n = matrix.length;
        int head = 0;
        int tail = n-1;
        
        while(head < tail){
            for(int i = 0; i <  n; i++){
                swap(matrix,head,i,tail,i);
            }
            head++;
            tail--;
        }
    }
    
    public void swap(int[][] matrix, int beforeRow, int beforeCol, int afterRow, int afterCol){
        if(beforeRow == afterRow && beforeCol == afterCol) return;
        int temp = matrix[beforeRow][beforeCol];
        matrix[beforeRow][beforeCol] = matrix[afterRow][afterCol];
        matrix[afterRow][afterCol] = temp;
    }
}