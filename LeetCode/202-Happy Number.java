/*

http://www.cnblogs.com/grandyang/p/4447233.html

1^2 + 1^2 = 2
2^2 = 4
4^2 = 16
1^2 + 6^2 = 37
3^2 + 7^2 = 58
5^2 + 8^2 = 89
8^2 + 9^2 = 145
1^2 + 4^2 + 5^2 = 42
4^2 + 2^2 = 20
2^2 + 0^2 = 4

我们发现在算到最后时数字4又出现了，那么之后的数字又都会重复之前的顺序，
这个循环中不包含1，那么数字11不是一个快乐数，发现了规律后就要考虑怎么用代码来实现，
我们可以用哈希表来记录所有出现过的数字，然后每出现一个新数字，在哈希表中查找看是否存在，
若不存在则加入表中，若存在则跳出循环，并且判断此数是否为1，若为1返回true，不为1返回false，
*/

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
     
        while(!set.contains(n)){
            set.add(n);
     
            n = sum(getDigits(n));
            if (n == 1) {
                return true;
            }
        }
     
        return false;
    }
     
    public int sum(int[] arr){
        int sum = 0;
        for(int i: arr){
            sum = sum + i * i;
        }
        return sum;
    }
     
    public int[] getDigits(int n){
        String s = String.valueOf(n);
        int[] result = new int[s.length()];
        int i = 0;
     
        while(n > 0){
            int m = n % 10;
            result[i++] = m;
            n = n / 10;
        }
     
        return result;
    }
}