import java.util.*;


//You are given a telephone keyboard
//
//0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 6-MNO6,7-PQRS7, 8-TUV8, 9-WXYZ9, *-space, #-char separater
// if you type "2", you will get 'A', that is "2"-'A', "22"-'B' ,"222"-'C', "2222"-'D'
// However, the digits can repeated many times
// "22222"-you get 'A' again 
// You can use "#" to separate characters, for example
// "2#22", you get "AB"
// However, you may also have consecutive different digits without separator:"23"-'AD'
//If you type "*", it means space.
// You a given a sequence of digits, translate it into a text message


public class SMS1 {
	
	String[] board = {"0","1","ABC2","DEF3","GHI4","JKL5","MNO6","PQRS7","TUV8","WXYZ9"};
	
	public String sol(String digits){
		if(digits == null || digits.length()==0) return "";
		String text = "";
		char last = digits.charAt(0);
		int times = 1;
		for(int i = 1; i < digits.length(); i ++){
			char curr = digits.charAt(i);
			if(curr == last){
				times++;
				continue;
			}
			if(curr == '#'){
				text += getMeaning(last,times);
				times = 0;//注意这里要回0
				continue;
			}
			text += getMeaning(last,times);
			last = curr;
			times = 1;
		}
		text += getMeaning(last,times);
		return text;
	}
	
	public String getMeaning(char c, int times){
		String result = "";
		if(c == '*'){
			while(times>0){
				result += " ";
				times--;
			}
		}else if(c=='0'||c=='1'){
			while(times>0){
				result += c;
				times--;
			}
		}else{
			int index = Character.getNumericValue(c);
			String possible = board[index];
			int len = possible.length();
			result += possible.charAt((times-1)%len);
		}
		return result;
	}
}