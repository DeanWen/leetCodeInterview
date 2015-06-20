import java.util.*;



//In 1-9 keypad one key is not working. If someone enters a password then not working key will not be entered. You have givenexpected password and entered password.
//Check that entered password is valid ornot. 
//Ex: entered 164, expected 18684 (you need to take care as when u enter18684 and 164 only both will be taken as 164 input)



public class ValidPassword {
	
	public void test(){
		boolean isValid = sol("164", "18684", 8);
		System.out.println(isValid);
	}
	
	public boolean sol(String expect, String entered, int wrongKey){
		if(expect.length() > entered.length()) return false;
		
		String faultykey = wrongKey + "";
		char broken = faultykey.charAt(0);
		
		int head = 0;
		for(int i = 0; i < expect.length();  i++){
			char curr = expect.charAt(i);
			if(curr == entered.charAt(head)){
				head++;
				continue;
			}else{
				if(entered.charAt(head) == broken){
					head ++;
					i--;
					continue;
				}
				return false;
			}
		}
		
		return true;
	}
	
	
}