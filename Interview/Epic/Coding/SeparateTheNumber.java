import java.util.*;



//Print the sequences from the input given bythe user separated by semicolon 
//e.g.: 4678912356012356 
//output: 4;6789;123;56;0123;56;

//有的地方是说打印长度大于1的SEQUENCE， 这里直接加个参数，表示需要的最小长度好了
//Assume 9 is not followed by 0, increase order, all numbers.

public class SeparateTheNumber {
	
	public void test(){
		String result = sol("4678912356012356", 1);
		System.out.println(result);
	}
	
	public String sol(String input, int length){
		input += "|"; //without this "56" will not display
		StringBuilder result = new StringBuilder();
		String temp = input.charAt(0) + "";
		char last = input.charAt(0);
		for(int i = 1; i < input.length(); i++){
			char curr = input.charAt(i);
			if(curr - last == 1){
				temp += (curr + "");
				last = curr;
			}else{
				if(temp.length() >= length){
					result.append(temp + ";");
				}
				temp = curr + "";
				last = curr;
			}
		}
		
		
		return result.toString();
	}
	
}