import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Given a string that has{},[],() and characters.Check if the string is balanced. E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.



public class BalancedString {
	
	public void test(){
		boolean balanced = sol("{a[(b])}");
		System.out.println(balanced);
	}
	
	public boolean sol(String check){
		Stack<Character> st = new Stack<Character>();
		if(check == null || check.length() == 0) return true;
		for(int i = 0; i < check.length(); i++){
			char curr = check.charAt(i);
			if(curr == '{' || curr == '[' || curr == '('){
				st.push(curr);
			}
			if(curr =='}' || curr == ']' || curr == ')'){
				if(st.isEmpty()) return false;
				char top = st.peek();
				if(curr == '}'){
					if(top != '{'){
						return false;
					}else{
						st.pop();
					}
				}
				if(curr == ']'){
					if(top != '['){
						return false;
					}else{
						st.pop();
					}
				}
				if(curr == ')'){
					if(top != '('){
						return false;
					}else{
						st.pop();
					}
				}
			}
		}
		return st.isEmpty();
	}
	
	
}