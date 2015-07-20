/*
* https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
* Time Complexity : O(n)
* Space Complexity : O(n)
*/

public class Solution {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] used = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!used[i - 1]) {
                int temp = i * i;
                while (temp < n) {
                    used[temp - 1] = true;
                    temp += i;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!used[i - 1]) {
                res++;
            }
        }
        return res;
    }
}

/*
* Solution 2 
*   use isPrime method
* Time Complexity : O(n^2)
* Spac Complexity : O(1)
*/
public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    
    public boolean isPrime(int num) {
        if (num == 2) return true;
        if (num < 2 || num % 2 == 0) {
            return false; 
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}