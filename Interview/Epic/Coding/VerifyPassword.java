import java.util.*;



//Verify if the given password is valid/invalid
//1. must be 5-12 characters long
//2. must contain at least one number and one lowercase character 
// 3. a sequence must not be followed by the same sequence (like 123123qs isinvalid, 123qs123 is valid)



public class VerifyPassword {
	
	public void test(){
		boolean isValid = sol("111111");
		System.out.println(isValid);
	}
	
	public boolean sol(String password){
		int len = password.length();
		//check length
		if(len < 5 || len > 12) return false;
		
		boolean containsNumber = false;
		boolean containsLowerCase = false;
		
		for(int i = 0; i < len; i++){
			char curr = password.charAt(i);
			if(!containsLowerCase || !containsNumber){
				if('0' <= curr && curr <= '9') containsNumber = true;
				if('a' <= curr && curr <= 'z') containsLowerCase = true;
			}
			int index = password.indexOf(curr, i+1);
			if(index == -1 || len - index < index - i) continue;
			String phase1 = password.substring(i,index-1+1);
			String phase2 = password.substring(index, index + phase1.length());
			if(phase1.equals(phase2)) return false;
		}
		
		return containsNumber&&containsLowerCase;
	}
	
	
}