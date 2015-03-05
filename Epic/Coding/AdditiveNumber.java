import java.util.*;



//Anadditive sequence is 1,2,3,5,8,13 where T(n) = T(n -1) + T(n - 2). A numberrange is given to you. Find the additive sequence number in that range.

//Given the start and an ending integer as userinput, generate all integers with the following property. 

//Assume: 12 is invalid. 123 is valid 1212 is invalid 121224 is valid
public class AdditiveNumber {
	
	public int slen;
	public int elen;
	
	public void test(){
		this.sol(112, 9999);
	}
	
	public void sol(int s, int e){
		int start = s;
		if(s== 0){
			System.out.println(s);
			start = 1;
		}
		String sstring = "" + start;
		String estring = "" + e;
		slen = sstring.length();
		elen = estring.length();
		if(elen < 3) return;   //number < 100 are not additive number
		helper(start,e,"",-1,-1);
	}
	
	public void helper(int s, int e, String path, int lastlast, int last){
		int pathlen = path.length();
		if(lastlast == -1){
			int max = 1;
			int temp = elen/2;
			while (temp > 0){
				max *= 10;                 //1 + 99 = 100 -> 199100   199100 length = 6, a number with length 6 can only generate from a digit and some number with length 6/2 = 3
				temp--;
			}
			for(int i = 1; i < max; i++){
				for(int j = 0; j < max; j++){
					String init = (i +"");
					init += j +"";
					init += (i+j) + "";
					helper(s,e,init,j,i+j);
				}
			}
			return;
		}
		
		int curr = Integer.valueOf(path);
		if(pathlen > elen) return;
		
		if(pathlen >= slen && pathlen <= elen){
			if(curr >= s && curr <= e) System.out.println(path);
		}
		
		int next = last + lastlast;
		
		helper(s,e,path + next, last, next);
		
	}
}