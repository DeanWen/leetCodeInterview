import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//There¡¯s a word guessing game. One personthink a word, and the other one guess a word, 
//both words have the same length.The person should return the number of bulls and cows for the guessing. 
//		Bullsrepresent the number of same characters in the same spots, whereas cowsrepresent the number of characters guessed right but in the wrong spots. 
//Writea program with two input strings, return the number of bulls and cows.

//make the words can have different length here. 
//when finding the cows number, the idea is similar with checking the anagram, so we use char array here.
public class BullsAndCowsGame {

	public void test() {
		int[] result = sol("dusts", "studs");
		System.out.println(result[0] + " Bulls and " + result[1] + " Cows");
		result = sol("Picture", "epic");
		System.out.println(result[0] + " Bulls and " + result[1] + " Cows");
		result = sol("forum", "four");
		System.out.println(result[0] + " Bulls and " + result[1] + " Cows");
	}

	public int[] sol(String s1, String s2) {
		int s1len = s1.length();
		int s2len = s2.length();
		int[] result = new int[2];
		if (s1 == null || s2 == null) {
			System.out.println("inputted words are invalid");
			return null;
		}
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		result[0] = this.getExact(s1, s2);
		result[1] = this.getSimilar(s1, s2) - result[0];
		return result;
	}
	
	public int getExact(String s1, String s2){
		int result = 0;
		for(int i = 0; i < Math.min(s1.length(), s2.length()); i++){
			if(s1.charAt(i) == s2.charAt(i)) result ++;
		}
		return result;
	}
	
	public int getSimilar(String s1, String s2){
		int[] charArrayS1 = this.getCharCount(s1);
		int[] charArrayS2 = this.getCharCount(s2);
		int result = 0;
		for(int i = 0; i < 256; i++){
			result += Math.min(charArrayS1[i], charArrayS2[i]);
		}
		return result;
	}
	
	public int[] getCharCount(String s1){
		int[] result = new int[256];
		for(int i = 0; i<s1.length(); i++){
			char curr = s1.charAt(i);
			result[curr]++;
		}
		return result;
	}

}