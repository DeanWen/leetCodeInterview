import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Replace a,e,i,o,u with A,E,I,O,U.
//At most four eligible letters from the rearof the string are replaced.
//The first three eligible letters in thestring are always exempted from replacement.

//优先头三个，多的从后面开始4个，再多就不换了
public class ReplaceAEIOU {
	
	Map<Character,Character> themap = new HashMap<Character,Character>();
	
	public void test(){
		this.init();
		String newString = sol("A person can't walk in this streeta");
		System.out.println(newString);
	}
	
	public void init(){
		themap.put('a', 'A');
		themap.put('e', 'E');
		themap.put('i', 'I');
		themap.put('o', 'O');
		themap.put('u', 'U');
	}
	
	public String sol(String change){
		StringBuilder result = new StringBuilder(change);
		int numberChangeOfHead = 3;
		int mostChangeOfTail = 4;
		int theThirdIndex = -1;
		for(int i = 0; i < result.length(); i++){
			char curr = result.charAt(i);
			if(themap.containsKey(curr)){
				result.replace(i, i+1, themap.get(curr)+"");
				numberChangeOfHead --;
				if(numberChangeOfHead == 0){
					theThirdIndex = i;
					break;
				}
			}
		}
		
		for(int i = result.length() - 1; i > theThirdIndex; i--){
			char curr = result.charAt(i);
			if(themap.containsKey(curr)){
				result.replace(i, i+1, themap.get(curr)+"");
				mostChangeOfTail --;
				if(mostChangeOfTail == 0){
					break;
				}
			}
		}
		return result.toString();
	}
	
	
}