import java.text.DecimalFormat;
import java.util.*;


//The hit rate of the basketball game is given by the number of hits divided
//by the number of chances. For example, you have 73 chances but hit 15 times,
//then your hit rate is 15/73=0.205 (keep the last 3 digits). On average, you
//have 4.5 chances in each basketball game. Assume the total number of games
//is 162. Write a function for a basketball player. He will input the number
//of hits he has made, the number of chances he had, and the number of
//remaining games. The function should return the number of future hits, so
//that he can refresh his hit rate to 0.45

//attention: 总共应该的HIT数 4.5*162*0.45 已经用掉的HIT数 hits/chance * (162-remain) * 4.5
public class Basketballhitrates {

	public void test(){
		String result = sol(1,5,155);
		System.out.println(result);
	}
	
	public String sol(int hits, int chance, int remain){
		double currrate = hits/chance;
		DecimalFormat df = new DecimalFormat("0.000");
		double result = 4.5*162*0.45 - 4.5*(162-remain)*currrate;
		String s = df.format(result);
		return s;
	}

}