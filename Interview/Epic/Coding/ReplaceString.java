import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Froma given string, replace all instances of 'a' with 'one' and 'A' with 'ONE'.
//Example Input: " A boy is playing in a garden"
//Example Output: " ONE boy is playing in onegarden"
//-- Not that 'A' and 'a' are to be replaced only when theyare single characters, not as part of another word.



public class ReplaceString {
	
	public void test(){
		String newString = sol("A boy is playing in a garden");
		System.out.println(newString);
	}
	
	public String sol(String change){
		Pattern pattern = Pattern.compile("\\b[Aa]\\b");
		Matcher m = pattern.matcher(change);
		return m.replaceAll("one");
	}
	
	
}