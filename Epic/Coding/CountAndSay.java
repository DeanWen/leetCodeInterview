import java.util.*;



//First,let user input a number, say 1. Then, the function will generate the next 10numbers which satisfy this condition: 1, 11,21,1211,111221,312211... 
//explanation: first number 1, second number is one 1, so 11. Third number is two1(previous number), so 21. next number one 2 one 1, so 1211 and so on...



public class CountAndSay {
	
	public void test(){
		sol(1);
	}
	
	public void sol(int numbers){
		StringBuilder result = new StringBuilder(numbers+" ");
		String numberString = numbers + "";		
		String gen = numberString;
		for(int i = 0; i < 10; i++){
			gen = this.generate(gen);
			result.append(gen + " ");
		}
		
		System.out.println(result.toString());
	}
	
	public String generate(String num){
		String result = "";
		char last = num.charAt(0);
		int count = 1;
		for(int i = 1; i < num.length(); i++){
			char curr = num.charAt(i);
			if(curr == last){
				count++;
			}else{
				result += (count + "") + last; 
				last = curr;
				count = 1;
			}
		}
		result += (count + "") + last;
		return result;
	}
	
}