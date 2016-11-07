//https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n
//pattern is like k = k - (index from previous) * (n-1)! = k - 2*(n-1)! = 13 - 2*(3)! = 1
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new LinkedList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        
        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        
        // create a list of numbers to get indices
        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}
        
        k--;
        
        for(int i = 1; i <= n; i++){
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }
        
        return sb.toString();
    }
}
