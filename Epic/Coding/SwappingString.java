import java.util.*;


//Transpose a string means re-sequencing a string
//If you transpose string1 to string2, you can only swap the adjacent two
//characters each time, until you get your target string.
//
//For example, you want to transpose GUW to WUG, the steps are
//GUW
//GWU
//WGU
//WUG

public class SwappingString {

	//assume src and target are anagrams
	public void sol(String src, String target){
		System.out.println(src);
		helper(0,src,target);
		System.out.println(target);
	}
	
	public void helper(int pointer, String src, String target){
		if(pointer >= target.length()-1) return;
		char curr = target.charAt(pointer);
		StringBuilder sb = new StringBuilder(src);
		for(int i = pointer; i < src.length(); i++){
			if(src.charAt(i) == curr){
				shift(i,pointer,sb);
				break;
			}
		}
		helper(pointer+1, src, target);
	}

	public void shift(int from, int to, StringBuilder sb){
		if(from == to) return;
		int temp = from;
		while(temp != to){
			temp --;
			char tempchar = sb.charAt(temp);
			sb.setCharAt(temp, sb.charAt(temp+1));
			sb.setCharAt(temp+1, tempchar);
			System.out.println(sb.toString());
		}
	}
}