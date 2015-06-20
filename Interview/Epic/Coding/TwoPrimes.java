import java.util.*;


//Goldbach's conjecture : Every even integer greater than 2 can be expressed as the sum of two primes.
//Write a functionwhich takes a number as input, verify if is an even number greater than 2 andalso print at least one pair of prime numbers.




public class TwoPrimes {

	boolean[] prime;
	HashSet<Integer> primes = new HashSet<Integer>();
	
	public void sol(int n){
		if(n <= 2 || n%2 != 0){
			System.out.println("rule violation");
			return;
		}
		this.setUpPrimeArray(n);
		
		for(int ele: primes){
			if(primes.contains(n-ele)){
				System.out.println("pair is:" + ele + " with " + (n-ele));
				return;
			}
		}
		
		System.out.println("not found");
	}
	
	public void setUpPrimeArray(int n){
		prime = new boolean[n+1];
		
		primes.add(1);
		
		for(int i = 2; i < prime.length; i++){
			if(prime[i]) continue; //注意， array是不是PRIME的设为TRUE， 因为新建后默认是全FALSE的
			primes.add(i);
			for(int j = 2; j*i < prime.length; j++){
				prime[j*i] = true;
			}
		}
	}
}