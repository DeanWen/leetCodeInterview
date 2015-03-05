import java.util.*;



//A number is called as a stepping number if the adjacent digits are having adifference of 1. For eg. 8,343,545 are stepping numbers. While 890, 098 arenot. The difference between a ¡®9¡¯ and ¡®0¡¯ should not be considered as1. 
//Given start number(s) and an end number (e) your function should listout all the stepping numbers in the range including both the numbers s & e.


public class TheSteppingNumber {
	
	public int slen;
	public int elen;
	
	public void sol(int s, int e){
		int start = s;
		if(s == 0 && e == 1) return;
		if(s== 0){
			System.out.println(s);
			start = 1;
		}
		String sstring = "" + start;
		String estring = "" + e;
		slen = sstring.length();
		elen = estring.length();
		helper(start,e,"");
	}
	
	public void helper(int s, int e, String path){
		int pathlen = path.length();
		if(pathlen > elen) return;
		if(pathlen >= slen){
			int result = Integer.valueOf(path);
			if(result >= s && result <= e){
				System.out.println(result);
			}
		}
		if(pathlen == 0){
			for(int i = 1; i <=9; i++){
				path += i;
				helper(s,e,path);
				path = path.substring(0, path.length()-1);
			}
		}else{
			char last = path.charAt(pathlen-1);
			int lastdigit = Character.getNumericValue(last);
			if(lastdigit != 9){
				path += (lastdigit+1);
				helper(s,e,path);
				path = path.substring(0, path.length()-1);
			}
			if(lastdigit != 0){
			path += (lastdigit-1);
			helper(s,e,path);
			path = path.substring(0, path.length()-1);
			}
		}
		
		
	}
}