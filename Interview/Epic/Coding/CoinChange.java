import java.util.*;



//Somethingcost $10.25 and the customer pays with a $20 bill, the program will print outthe most efficient "change-breakdown" which is 1 five, 4 ones, and 3quarters. 
//Find the minimum number of coins required to make change for a givensum (given unlimited cumber of N different denominations coin)

public class CoinChange {
	
	Map<Double, Integer> usedCoin = new HashMap<Double,Integer>();
	double[] coins = {5,1,0.25,0.1,0.05,0.01};
	
	public void test(){
		this.sol(10.25, 20);
		for(double ele: usedCoin.keySet()){
			if(usedCoin.get(ele) != 0){
				System.out.print(ele + ":" + usedCoin.get(ele) + " ");
			}
		}
	}
	
	public Map<Double, Integer> sol(double needPay, double paid){
		usedCoin.put(5.0, 0);
		usedCoin.put(1.0, 0);
		usedCoin.put(0.25, 0);
		usedCoin.put(0.1, 0);
		usedCoin.put(0.05, 0);
		usedCoin.put(0.01, 0);
		helper(paid-needPay);
		return usedCoin;
	}
	
	public boolean helper(double remain){
		if(remain < 0) return false;
		if(remain == 0) return true;
		
		for(int i = 0; i < coins.length; i++){
			if(remain >= coins[i]){
				usedCoin.put(coins[i], usedCoin.get(coins[i]) + 1);
				boolean success = helper(remain-coins[i]);
				if(success) return true;
				usedCoin.put(coins[i], usedCoin.get(coins[i]) - 1);
			}
		}
		
		return false;
	}
}