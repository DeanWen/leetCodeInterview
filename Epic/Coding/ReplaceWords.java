import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Given a string.Replace the words whose length>=4 and is even,with a space between the two equal halves of the word.
//consider only alphabets for finding the eveness of the word 
//I/P "A person can't walk in this street" 
//O/P "A per son ca n't wa lk in th is stre et"

//注意，符号不算在长度里
//注意 StringBuilder的insert 是insert第几个字母，而不是INDEX  dddd insert(1," "); d ddd

public class ReplaceWords {
	
	public void test(){
		String newString = sol("A person can't walk in this street");
		System.out.println(newString);
	}
	
	public String sol(String change){
		change += " ";
		int tempLen = 0;
		StringBuilder word = new StringBuilder();
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < change.length(); i++){
			char curr = change.charAt(i);
			if(curr == ' '){
				if(tempLen >= 4 && tempLen % 2 == 0){
					this.insertSpace(word, tempLen);
				}
				result.append(word);
				result.append(" ");
				tempLen = 0;
				word = new StringBuilder();
				continue;
			}
			if((curr >= 'a' && curr <= 'z')||(curr >= 'A' && curr <= 'Z')) tempLen ++;
			word.append(curr);
		}
		return result.toString();
	}
	
	public void insertSpace(StringBuilder word, int tempLen){
		if(tempLen == 0) return;
		int pointer = 0;
		while(pointer != (tempLen-1)/2){
			char curr = word.charAt(pointer);
			if((curr >= 'a' && curr <= 'z')||(curr >= 'A' && curr <= 'Z'))
			pointer++;
		}
		word.insert(pointer+1, " ");
	}
	
	
}